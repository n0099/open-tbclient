package d.a.p0.v.d.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f64228a;

    /* renamed from: b  reason: collision with root package name */
    public String f64229b;

    /* renamed from: c  reason: collision with root package name */
    public String f64230c;

    /* renamed from: d  reason: collision with root package name */
    public String f64231d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f64232e;

    /* renamed from: f  reason: collision with root package name */
    public int f64233f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f64234g;

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
        this.f64228a = hotLiveWithCategory.tab_id.intValue();
        this.f64229b = hotLiveWithCategory.entry_name;
        this.f64230c = hotLiveWithCategory.label_name;
        this.f64231d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f64232e = new ArrayList(hotLiveWithCategory.live);
        this.f64233f = hotLiveWithCategory.live_tab_type.intValue();
        this.f64234g = hotLiveWithCategory.sub_type_list;
    }
}
