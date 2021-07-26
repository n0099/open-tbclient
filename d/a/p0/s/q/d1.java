package d.a.p0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbPage.NewsInfo;
/* loaded from: classes7.dex */
public class d1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f53282a;

    /* renamed from: b  reason: collision with root package name */
    public String f53283b;

    /* renamed from: c  reason: collision with root package name */
    public int f53284c;

    /* renamed from: d  reason: collision with root package name */
    public String f53285d;

    /* renamed from: e  reason: collision with root package name */
    public String f53286e;

    /* renamed from: f  reason: collision with root package name */
    public String f53287f;

    public d1() {
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

    public void a(NewsInfo newsInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, newsInfo) == null) || newsInfo == null) {
            return;
        }
        this.f53282a = newsInfo.news_link;
        this.f53283b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f53284c = newsInfo.news_type.intValue();
        this.f53285d = newsInfo.news_icon;
        this.f53286e = newsInfo.subtitle;
        this.f53287f = newsInfo.button_text;
    }
}
