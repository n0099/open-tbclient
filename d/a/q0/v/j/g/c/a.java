package d.a.q0.v.j.g.c;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import d.a.p0.s.s.a;
import d.a.q0.v.j.g.a;
import d.a.q0.v.j.g.b;
/* loaded from: classes8.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f65529e;

    /* renamed from: f  reason: collision with root package name */
    public View f65530f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f65531g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f65532h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f65533i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public MarkLevelGroup m;
    public TextView n;
    public d.a.q0.v.j.g.c.c.b o;
    public AlaUpdateMarkStatusModel p;
    public i q;
    public LinearLayout r;
    public TextView s;
    public TextView t;
    public LinearLayout u;
    public TextView v;
    public d.a.q0.v.j.g.b w;
    public d.a.q0.v.j.g.a x;

    /* renamed from: d.a.q0.v.j.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1785a implements AlaUpdateMarkStatusModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65534a;

        public C1785a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65534a = aVar;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.b
        public void onResult(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                this.f65534a.n.setEnabled(true);
                if (z) {
                    if (this.f65534a.q != null) {
                        this.f65534a.q.a(true, this.f65534a.o);
                    }
                    this.f65534a.dismiss();
                    return;
                }
                if (StringUtils.isNull(str)) {
                    str = this.f65534a.getContext().getResources().getString(R.string.ala_achievement_ops_failed_tip);
                }
                this.f65534a.f65529e.showToast(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65535a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65535a = aVar;
        }

        @Override // d.a.q0.v.j.g.b.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f65535a.o.n <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                this.f65535a.v();
                this.f65535a.u();
                this.f65535a.s();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65536a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65536a = aVar;
        }

        @Override // d.a.q0.v.j.g.a.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.f65536a.o != null) {
                        this.f65536a.f65529e.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (this.f65536a.q != null) {
                            this.f65536a.q.a(true, this.f65536a.o);
                        }
                        this.f65536a.o.q(2);
                        this.f65536a.v();
                        this.f65536a.u();
                        this.f65536a.s();
                    }
                } else if (!StringUtils.isNull(str)) {
                    this.f65536a.f65529e.showToast(str);
                } else {
                    this.f65536a.f65529e.showToast(R.string.ala_achievement_tdou_buy_fail);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65537e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65537e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f65537e.q != null) {
                    this.f65537e.q.a(false, this.f65537e.o);
                }
                this.f65537e.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements MarkLevelGroup.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65538a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65538a = aVar;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.b
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.f65538a.t(str, str2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65539e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65539e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f65539e.o.j() == 0 || 3 == this.f65539e.o.j()) {
                    if (this.f65539e.o.m()) {
                        if (this.f65539e.o.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (this.f65539e.w != null) {
                                this.f65539e.w.c(this.f65539e.o.n);
                            }
                        } else if (this.f65539e.x != null) {
                            this.f65539e.x.c(this.f65539e.o.d(), this.f65539e.o.m, false);
                        }
                    } else if (this.f65539e.o.l()) {
                    } else {
                        this.f65539e.dismiss();
                    }
                } else if (!this.f65539e.o.k() || 2 != this.f65539e.o.j()) {
                    this.f65539e.q();
                } else {
                    this.f65539e.r();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65540e;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65540e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f65540e.n.setEnabled(false);
                this.f65540e.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65541e;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65541e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface i {
        void a(boolean z, d.a.q0.v.j.g.c.c.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(417447703, "Ld/a/q0/v/j/g/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(417447703, "Ld/a/q0/v/j/g/c/a;");
                return;
            }
        }
        y = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
        z = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext, i iVar) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, iVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65529e = tbPageContext;
        this.q = iVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.dismiss();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlaUpdateMarkStatusModel alaUpdateMarkStatusModel = new AlaUpdateMarkStatusModel(getContext());
            this.p = alaUpdateMarkStatusModel;
            alaUpdateMarkStatusModel.z(new C1785a(this));
            d.a.q0.v.j.g.b bVar = new d.a.q0.v.j.g.b(this.f65529e);
            this.w = bVar;
            bVar.e(new b(this));
            this.x = new d.a.q0.v.j.g.a(this.f65529e, new c(this));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = getLayoutInflater().inflate(R.layout.ala_achievement_mark_mask_layout, (ViewGroup) null);
            this.f65530f = inflate;
            setContentView(inflate);
            this.f65530f.setOnClickListener(new d(this));
            TbImageView tbImageView = (TbImageView) this.f65530f.findViewById(R.id.mark_img);
            this.f65531g = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f65531g.setDefaultResource(R.drawable.pic_live_honor);
            this.f65532h = (FrameLayout) this.f65530f.findViewById(R.id.mark_img_layout);
            this.f65533i = (TextView) this.f65530f.findViewById(R.id.mark_title);
            this.j = (RelativeLayout) this.f65530f.findViewById(R.id.mark_desc_layout);
            this.k = (TextView) this.f65530f.findViewById(R.id.mark_desc);
            this.l = (TextView) this.f65530f.findViewById(R.id.mark_upgrade_desc);
            MarkLevelGroup markLevelGroup = (MarkLevelGroup) this.f65530f.findViewById(R.id.mark_level_view);
            this.m = markLevelGroup;
            markLevelGroup.setCallback(new e(this));
            this.n = (TextView) this.f65530f.findViewById(R.id.mark_ops_btn);
            this.t = (TextView) this.f65530f.findViewById(R.id.mark_limit_time);
            this.r = (LinearLayout) findViewById(R.id.mark_tdou_layout);
            this.s = (TextView) findViewById(R.id.mark_tdou_price);
            this.u = (LinearLayout) findViewById(R.id.user_tdou_layout);
            this.v = (TextView) findViewById(R.id.user_tdou_price);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                getWindow().addFlags(134217728);
            }
            super.onCreate(bundle);
            getWindow().requestFeature(1);
            o();
            m();
            n();
        }
    }

    public void p() {
        AlaUpdateMarkStatusModel alaUpdateMarkStatusModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alaUpdateMarkStatusModel = this.p) == null) {
            return;
        }
        alaUpdateMarkStatusModel.onDestroy();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (1 == this.o.j()) {
                this.p.A(false, this.o.d());
            } else if (2 == this.o.j()) {
                this.p.A(true, this.o.d());
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f65529e.getPageActivity());
            aVar.setMessageShowCenter(true);
            aVar.setCanceledOnTouchOutside(false);
            aVar.setTitle(R.string.ala_achievement_ops_alert_title);
            aVar.setMessageId(R.string.ala_achievement_ops_alert_content);
            aVar.setPositiveButton(R.string.dialog_ok, new g(this));
            aVar.setNegativeButton(R.string.dialog_cancel, new h(this));
            aVar.create(this.f65529e).show();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k.setVisibility(4);
            this.l.setVisibility(4);
            this.r.setVisibility(4);
            this.m.setVisibility(4);
            this.u.setVisibility(8);
            if (this.o.m()) {
                this.r.setVisibility(0);
                this.u.setVisibility(0);
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.s.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds8));
                this.s.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.s.setText(AlaStringHelper.formatLowercasekDou((float) this.o.n));
                this.v.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
                this.v.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.v.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                if (this.o.j() == 1) {
                    this.u.setVisibility(8);
                }
            } else if (this.o.l()) {
                this.k.setVisibility(0);
                this.k.setText(this.o.a());
            } else {
                this.m.setVisibility(0);
                this.k.setVisibility(0);
                this.l.setVisibility(0);
                this.k.setText(this.o.a());
                this.l.setText(this.o.i());
                this.m.f(this.o);
            }
        }
    }

    public final void t(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            if (StringUtils.isNull(str)) {
                this.f65531g.M(String.valueOf(R.drawable.pic_live_honor), 24, false);
            } else {
                this.f65531g.M(str, 10, false);
            }
            this.f65533i.setText(str2);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.o.j() != 1 && this.o.j() != 2) {
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(0);
            this.t.setText(this.o.b());
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int j = this.o.j();
            if (j != 0) {
                if (j != 1) {
                    if (j != 2) {
                        if (j == 3) {
                            if (this.o.m()) {
                                this.n.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                                this.n.setTextSize(0, z);
                                this.n.setText(R.string.ala_enter_effect_tdou_buy);
                                this.n.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                                if (this.o.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                                    this.n.setText(R.string.ala_achievement_get_tdou_label);
                                }
                            } else if (this.o.l()) {
                                this.n.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                                this.n.setTextSize(0, z);
                                this.n.setText(R.string.ala_nobility_open);
                                this.n.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                            } else {
                                this.n.setBackgroundResource(R.drawable.transparent_bg);
                                this.n.setTextSize(0, y);
                                this.n.setText(R.string.ala_achievement_mark_status_expired);
                                this.n.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                            }
                        }
                    } else if (this.o.m()) {
                        this.n.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                        this.n.setTextSize(0, z);
                        this.n.setText(R.string.ala_achievement_wear_mark);
                        this.n.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    } else if (this.o.l()) {
                        this.n.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                        this.n.setTextSize(0, z);
                        this.n.setText(R.string.ala_achievement_wear_mark);
                        this.n.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    } else {
                        this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                        this.n.setTextSize(0, z);
                        this.n.setText(R.string.ala_achievement_wear_mark);
                        this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    }
                } else if (this.o.m()) {
                    this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.n.setTextSize(0, z);
                    this.n.setText(R.string.ala_achievement_unwear_mark);
                    this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                } else if (this.o.l()) {
                    this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.n.setTextSize(0, z);
                    this.n.setText(R.string.ala_achievement_unwear_mark);
                    this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                } else {
                    this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.n.setTextSize(0, z);
                    this.n.setText(R.string.ala_achievement_unwear_mark);
                    this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                }
            } else if (this.o.m()) {
                this.n.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                this.n.setTextSize(0, z);
                this.n.setText(R.string.ala_enter_effect_tdou_buy);
                this.n.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                if (this.o.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    this.n.setText(R.string.ala_achievement_get_tdou_label);
                }
            } else if (this.o.l()) {
                this.n.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                this.n.setTextSize(0, z);
                this.n.setText(R.string.ala_nobility_open);
                this.n.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
            } else {
                this.n.setBackgroundResource(R.drawable.transparent_bg);
                this.n.setTextSize(0, y);
                this.n.setText(R.string.ala_achievement_mark_status_unlock);
                this.n.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
            }
            this.n.setOnClickListener(new f(this));
        }
    }
}
