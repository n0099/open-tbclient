package d.a.s0.v.d.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67446a;

    /* renamed from: b  reason: collision with root package name */
    public String f67447b;

    /* renamed from: c  reason: collision with root package name */
    public String f67448c;

    /* renamed from: d  reason: collision with root package name */
    public String f67449d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f67450e;

    /* renamed from: f  reason: collision with root package name */
    public int f67451f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f67452g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotLiveWithCategory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67446a = hotLiveWithCategory.tab_id.intValue();
        this.f67447b = hotLiveWithCategory.entry_name;
        this.f67448c = hotLiveWithCategory.label_name;
        this.f67449d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f67450e = new ArrayList(hotLiveWithCategory.live);
        this.f67451f = hotLiveWithCategory.live_tab_type.intValue();
        this.f67452g = hotLiveWithCategory.sub_type_list;
    }
}
