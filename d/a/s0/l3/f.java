package d.a.s0.l3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.g;
import d.a.s0.h3.f0;
import d.a.s0.h3.w;
/* loaded from: classes9.dex */
public class f implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NewUserGuideActivity f63316e;

    /* renamed from: f  reason: collision with root package name */
    public InterestFrsData.Tag f63317f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.l3.a f63318g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f63319h;

    /* renamed from: i  reason: collision with root package name */
    public f0 f63320i;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f63321a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63321a = fVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj == null) {
                    this.f63321a.f63316e.showToast(R.string.neterror);
                } else if (obj instanceof w) {
                    int d2 = d.a.c.e.m.b.d(((w) obj).g(), 0);
                    this.f63321a.f63318g.b(d2);
                    this.f63321a.c(d2, true);
                    this.f63321a.f63316e.setHasLike(true);
                    this.f63321a.f63316e.setIsChanged(true);
                    TiebaStatic.eventStat(this.f63321a.f63316e.getPageContext().getPageActivity(), "notlogin_12", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f63322a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63322a = fVar;
        }

        @Override // d.a.s0.h3.f0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.f63322a.f63316e.showToast(R.string.error);
            }
        }

        @Override // d.a.s0.h3.f0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                int d2 = d.a.c.e.m.b.d(String.valueOf(j), 0);
                this.f63322a.f63318g.a(d2);
                this.f63322a.c(d2, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideMainFragment.b f63323e;

        public c(f fVar, NewUserGuideMainFragment.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63323e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f63323e.a();
            }
        }
    }

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, NewUserGuideMainFragment.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newUserGuideActivity, tag, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63316e = newUserGuideActivity;
        this.f63317f = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.f63318g = new e(this.f63316e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.f63318g = new d.a.s0.l3.b(this.f63316e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.f63318g = new d(this.f63316e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        LikeModel likeModel = new LikeModel(newUserGuideActivity.getPageContext());
        this.f63319h = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        f0 f0Var = new f0();
        this.f63320i = f0Var;
        f0Var.b(new b(this));
        this.f63318g.d(this);
        this.f63318g.c(this.f63317f);
        ((Dialog) this.f63318g).setOnDismissListener(new c(this, bVar));
    }

    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            for (int i3 = 0; i3 < this.f63317f.getCard_list().size(); i3++) {
                if (this.f63317f.getCard_list().get(i3).getFid() == i2) {
                    this.f63317f.getCard_list().get(i3).setIs_like(z ? 1 : 0);
                    return;
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NewUserGuideActivity newUserGuideActivity = this.f63316e;
            if (newUserGuideActivity == null || g.e(newUserGuideActivity.getPageContext().getPageActivity())) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
                scaleAnimation.setDuration(350L);
                this.f63318g.getRootView().setAnimation(scaleAnimation);
                this.f63318g.show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == R.id.box_close_layout) {
                this.f63318g.hide();
            } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
                InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
                if (card.getIs_like() == 1) {
                    this.f63320i.c(card.getFname(), card.getFid());
                } else {
                    this.f63319h.M(card.getFname(), String.valueOf(card.getFid()), "newuser");
                }
            }
        }
    }
}
