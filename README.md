  /*
    # JiaGouT
# 获取超类的泛型参数的实体类型
```
    public static Class<?> anylsisClasInfon(Object o) {
        Type type = o.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) type).getActualTypeArguments();
        return (Class<?>) params[0];
    }
*例子
public abstract class HttpCallBack<Result> implements ICallback {
    @Override
    public void Success(String success) {
        Gson gson = new Gson();
        Class<?> clz = anylsisClasInfon(this);
        Result objResult = (Result) gson.fromJson(success, clz);
        onSuccess(objResult);
    }

    public abstract void onSuccess(Result objResult);


    public static Class<?> anylsisClasInfon(Object o) {
        Type type = o.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) type).getActualTypeArguments();
        return (Class<?>) params[0];
    }
 getClass().getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
然后将其转换ParameterizedType。。
getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组。
[0]就是这个数组中第一个了。。
简而言之就是获得超类的泛型参数的实际类型。。
```