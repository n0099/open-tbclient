package d.a.p0.a3.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.l;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final int Q;
    public static final int R;
    public static final int S;
    public transient /* synthetic */ FieldHolder $fh;
    public Context C;
    public LinearLayout D;
    public LinearLayout E;
    public View F;
    public View G;
    public String H;
    public boolean I;
    public boolean J;
    public l.d K;
    public l.d L;
    public l.d M;
    public l.d N;
    public l.d O;
    public View.OnClickListener P;

    /* loaded from: classes7.dex */
    public class a extends ShareDialogItemView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context n;
        public EMTextView o;
        public LinearLayout.LayoutParams p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = context;
        }

        @Override // com.baidu.tieba.sharesdk.view.ShareDialogItemView
        public ShareDialogItemView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                super.a();
                addView(this.o, this.p);
                return this;
            }
            return (ShareDialogItemView) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f20881f = new ImageView(this.n);
                setTag(Integer.valueOf(i2));
                this.f20881f.setScaleType(ImageView.ScaleType.FIT_XY);
                WebPManager.setMaskDrawable(this.f20881f, i2, null);
                b();
            }
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                EMTextView eMTextView = new EMTextView(this.n);
                this.o = eMTextView;
                eMTextView.setTextSize(0, ShareDialogItemView.m);
                this.o.setText(i2);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                this.p = layoutParams;
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_T_X001);
                this.p.gravity = 1;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(376962804, "Ld/a/p0/a3/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(376962804, "Ld/a/p0/a3/g/b;");
                return;
            }
        }
        Q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
        R = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
        S = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, String str, boolean z, boolean z2, l.d dVar, l.d dVar2, l.d dVar3, l.d dVar4, l.d dVar5, View.OnClickListener onClickListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, str, Boolean.valueOf(z), Boolean.valueOf(z2), dVar, dVar2, dVar3, dVar4, dVar5, onClickListener};
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
        this.C = context;
        this.H = str;
        this.I = z;
        this.J = z2;
        this.K = dVar;
        this.L = dVar2;
        this.M = dVar3;
        this.N = dVar4;
        this.O = dVar5;
        this.P = onClickListener;
        this.D = (LinearLayout) this.f54046f.findViewById(R.id.first_line);
        this.E = (LinearLayout) this.f54046f.findViewById(R.id.second_line);
        b0();
    }

    @Override // d.a.p0.a3.g.d
    public boolean U() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.D.removeAllViews();
            this.E.removeAllViews();
            int i3 = 0;
            while (true) {
                if (i3 >= Math.min(6, this.k.size())) {
                    break;
                }
                this.D.addView(this.k.get(i3), new ViewGroup.LayoutParams(Q, R));
                i3++;
            }
            this.D.addView(this.F, new ViewGroup.LayoutParams(S, -1));
            for (i2 = 6; i2 < this.k.size(); i2++) {
                this.E.addView(this.k.get(i2), new ViewGroup.LayoutParams(Q, R));
            }
            this.E.addView(this.G, new ViewGroup.LayoutParams(S, -1));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k.clear();
            h(R.string.share_qq_friends, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
            h(R.string.share_qzone, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
            h(R.string.share_weixin, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
            a aVar = new a(this, this.C);
            aVar.c(R.drawable.icon_share_wechatexpression);
            aVar.setItemName(R.string.share_weixin_emotion_1);
            aVar.d(R.string.share_weixin_emotion_2);
            aVar.setOnClickListener(this);
            List<View> list = this.k;
            aVar.a();
            list.add(aVar);
            h(R.string.share_weixin_timeline, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
            h(R.string.share_sina_weibo, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
            if (this.H != null) {
                g(R.string.original_img_look, R.drawable.icon_pure_share_original40);
            }
            LinearLayout t = t(R.string.save_to_local, R.drawable.icon_pure_share_download40);
            t.setOnClickListener(this);
            t.setTag(Integer.valueOf(R.drawable.icon_pure_share_download40 + R.string.save_to_local));
            this.k.add(t);
            if (this.I) {
                g(R.string.save_to_emotion, R.drawable.icon_share_homepage_expression40);
            }
            g(R.string.identify_image, R.drawable.icon_share_homepage_scan40);
            if (this.J) {
                g(R.string.image_qr_code, R.drawable.icon_share_homepage_qrcode40);
            }
            this.F = new View(this.C);
            this.G = new View(this.C);
        }
    }

    @Override // d.a.p0.a3.g.d
    public void i(View view, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i2, onClickListener) == null) {
            super.i(view, i2, onClickListener);
        }
    }

    @Override // d.a.p0.a3.g.d, android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
            if (intValue == R.drawable.icon_pure_share_original40) {
                l.d dVar = this.M;
                if (dVar != null) {
                    dVar.onClick();
                }
            } else if (intValue == R.drawable.icon_pure_share_download40 + R.string.save_to_local) {
                l.d dVar2 = this.K;
                if (dVar2 != null) {
                    dVar2.onClick();
                }
            } else if (intValue == R.drawable.icon_share_homepage_expression40) {
                l.d dVar3 = this.L;
                if (dVar3 != null) {
                    dVar3.onClick();
                }
            } else if (intValue == R.drawable.icon_share_homepage_scan40) {
                l.d dVar4 = this.N;
                if (dVar4 != null) {
                    dVar4.onClick();
                }
            } else if (intValue == R.drawable.icon_share_homepage_qrcode40) {
                l.d dVar5 = this.O;
                if (dVar5 != null) {
                    dVar5.onClick();
                }
            } else if (intValue != R.drawable.icon_share_wechatexpression || (onClickListener = this.P) == null) {
            } else {
                onClickListener.onClick(view);
            }
        }
    }

    @Override // d.a.p0.a3.g.d
    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.image_viewer_share_dialog_layout, (ViewGroup) null) : (View) invokeV.objValue;
    }
}
