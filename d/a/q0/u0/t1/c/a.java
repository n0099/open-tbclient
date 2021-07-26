package d.a.q0.u0.t1.c;

import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64464a;

    /* renamed from: b  reason: collision with root package name */
    public int f64465b;

    /* renamed from: c  reason: collision with root package name */
    public List<b2> f64466c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f64467d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f64468e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f64469f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f64470g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f64471h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f64472i;
    public List<FeatureCardGame> j;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64466c = new ArrayList();
        this.f64468e = new ArrayList();
        this.f64469f = new ArrayList();
        this.f64470g = new ArrayList();
        this.f64471h = new ArrayList();
        this.f64472i = new ArrayList();
        this.j = new ArrayList();
    }
}
