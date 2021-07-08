package d.a.p0.u0.t1.c;

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
import d.a.o0.r.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f63819a;

    /* renamed from: b  reason: collision with root package name */
    public int f63820b;

    /* renamed from: c  reason: collision with root package name */
    public List<b2> f63821c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f63822d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f63823e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f63824f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f63825g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f63826h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f63827i;
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
        this.f63821c = new ArrayList();
        this.f63823e = new ArrayList();
        this.f63824f = new ArrayList();
        this.f63825g = new ArrayList();
        this.f63826h = new ArrayList();
        this.f63827i = new ArrayList();
        this.j = new ArrayList();
    }
}
