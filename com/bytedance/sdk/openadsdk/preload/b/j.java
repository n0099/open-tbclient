package com.bytedance.sdk.openadsdk.preload.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.i;
import com.bytedance.sdk.openadsdk.preload.b.l;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class j<IN, OUT> extends l<IN, OUT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f32296d;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract String a(b<OUT> bVar, IN in);

    public abstract String a(b<OUT> bVar, IN in, Throwable th, String str);

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x001b */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.bytedance.sdk.openadsdk.preload.b.b<OUT> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.bytedance.sdk.openadsdk.preload.b.b<OUT> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v8, resolved type: com.bytedance.sdk.openadsdk.preload.b.b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public final Object a_(b<OUT> bVar, IN in) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, in)) == null) {
            this.f32296d = a(new m(bVar), in);
            l.a aVar = a().get(this.f32296d);
            while (aVar != null) {
                List<h> list = aVar.f32299a;
                try {
                    Object a2 = c.a(list, bVar.f32292a, this).a((b) in);
                    return !a(list) ? a2 : bVar.a((b<OUT>) a2);
                } catch (i.a e2) {
                    this.f32296d = a(new m(bVar), in, e2.getCause(), this.f32296d);
                    aVar = a().get(this.f32296d);
                } catch (Throwable th) {
                    this.f32296d = a(new m(bVar), in, th, this.f32296d);
                    aVar = a().get(this.f32296d);
                }
            }
            throw new IllegalArgumentException("can not found branch，branch name is：" + this.f32296d);
        }
        return invokeLL.objValue;
    }
}
