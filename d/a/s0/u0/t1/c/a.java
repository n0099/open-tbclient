package d.a.s0.u0.t1.c;

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
import d.a.r0.r.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67036a;

    /* renamed from: b  reason: collision with root package name */
    public int f67037b;

    /* renamed from: c  reason: collision with root package name */
    public List<b2> f67038c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f67039d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f67040e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f67041f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f67042g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f67043h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f67044i;
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
        this.f67038c = new ArrayList();
        this.f67040e = new ArrayList();
        this.f67041f = new ArrayList();
        this.f67042g = new ArrayList();
        this.f67043h = new ArrayList();
        this.f67044i = new ArrayList();
        this.j = new ArrayList();
    }
}
