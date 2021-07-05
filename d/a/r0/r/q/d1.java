package d.a.r0.r.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbPage.NewsInfo;
/* loaded from: classes9.dex */
public class d1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f55903a;

    /* renamed from: b  reason: collision with root package name */
    public String f55904b;

    /* renamed from: c  reason: collision with root package name */
    public int f55905c;

    /* renamed from: d  reason: collision with root package name */
    public String f55906d;

    /* renamed from: e  reason: collision with root package name */
    public String f55907e;

    /* renamed from: f  reason: collision with root package name */
    public String f55908f;

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
        this.f55903a = newsInfo.news_link;
        this.f55904b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f55905c = newsInfo.news_type.intValue();
        this.f55906d = newsInfo.news_icon;
        this.f55907e = newsInfo.subtitle;
        this.f55908f = newsInfo.button_text;
    }
}
