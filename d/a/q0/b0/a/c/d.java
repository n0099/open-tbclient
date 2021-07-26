package d.a.q0.b0.a.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class d implements d.a.p0.i0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f55077e;

    /* renamed from: f  reason: collision with root package name */
    public int f55078f;

    /* renamed from: g  reason: collision with root package name */
    public String f55079g;

    /* renamed from: h  reason: collision with root package name */
    public String f55080h;

    /* renamed from: i  reason: collision with root package name */
    public String f55081i;

    public d(int i2, tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), tinfoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tinfoVar == null) {
            return;
        }
        this.f55077e = new ArrayList<>();
        this.f55078f = i2;
        this.f55080h = String.valueOf(tinfoVar.forum_id);
        this.f55079g = tinfoVar.forum_name;
        this.f55081i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f55077e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(this.f55077e);
            bVar.B(this.f55078f);
            bVar.z(this.f55079g);
            bVar.y(this.f55080h);
            bVar.O(this.f55081i);
            bVar.C(true);
            bVar.F(false);
            ArrayList<String> arrayList = this.f55077e;
            bVar.J(arrayList.get(arrayList.size() - 1));
            return new CustomMessage<>(2010000, bVar.v(context));
        }
        return (CustomMessage) invokeL.objValue;
    }
}
