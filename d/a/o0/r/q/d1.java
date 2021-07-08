package d.a.o0.r.q;

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
    public String f52618a;

    /* renamed from: b  reason: collision with root package name */
    public String f52619b;

    /* renamed from: c  reason: collision with root package name */
    public int f52620c;

    /* renamed from: d  reason: collision with root package name */
    public String f52621d;

    /* renamed from: e  reason: collision with root package name */
    public String f52622e;

    /* renamed from: f  reason: collision with root package name */
    public String f52623f;

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
        this.f52618a = newsInfo.news_link;
        this.f52619b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f52620c = newsInfo.news_type.intValue();
        this.f52621d = newsInfo.news_icon;
        this.f52622e = newsInfo.subtitle;
        this.f52623f = newsInfo.button_text;
    }
}
