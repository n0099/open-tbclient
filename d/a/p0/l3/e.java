package d.a.p0.l3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.g;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e extends Dialog implements d.a.p0.l3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f60068e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60069f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60070g;

    /* renamed from: h  reason: collision with root package name */
    public View f60071h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f60072i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60068e = context;
        f();
    }

    @Override // d.a.p0.l3.a
    public void a(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (findViewWithTag = this.f60072i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(false);
        }
    }

    @Override // d.a.p0.l3.a
    public void b(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (findViewWithTag = this.f60072i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(true);
        }
    }

    @Override // d.a.p0.l3.a
    public void c(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tag) == null) {
            this.f60069f.setText(tag.getBname());
            this.f60070g.setText(tag.getBdesc());
            ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
            int i2 = 0;
            while (i2 < card_list.size()) {
                View a2 = new a(this, card_list.get(i2), this.j).a();
                this.f60072i.addView(a2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                int dimensionPixelSize = this.f60068e.getResources().getDimensionPixelSize(R.dimen.ds40);
                layoutParams.setMargins(0, i2 == 0 ? this.f60068e.getResources().getDimensionPixelSize(R.dimen.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
                a2.setLayoutParams(layoutParams);
                if (i2 != card_list.size() - 1) {
                    this.f60072i.addView(LayoutInflater.from(this.f60068e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
                }
                i2++;
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            int size = (card_list.size() * getContext().getResources().getDimensionPixelSize(R.dimen.ds112)) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100);
            float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
            if (size > dimensionPixelSize2) {
                attributes.height = (int) dimensionPixelSize2;
            }
        }
    }

    @Override // d.a.p0.l3.a
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.j = onClickListener;
            this.k.setOnClickListener(onClickListener);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = View.inflate(this.f60068e, R.layout.new_user_box, null);
            this.l = inflate;
            setContentView(inflate);
            setCanceledOnTouchOutside(true);
            this.k = (LinearLayout) this.l.findViewById(R.id.box_close_layout);
            this.f60069f = (TextView) this.l.findViewById(R.id.prompt_title);
            this.f60070g = (TextView) this.l.findViewById(R.id.prompt_sub_title);
            this.f60071h = this.l.findViewById(R.id.view_layout);
            this.f60072i = (LinearLayout) this.l.findViewById(R.id.layout_content);
            this.f60071h.setBackgroundDrawable(this.f60068e.getResources().getDrawable(R.drawable.bg_startpage2_card_blue_up));
        }
    }

    @Override // d.a.p0.l3.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, d.a.p0.l3.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = this.f60068e;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }

    @Override // android.app.Dialog, d.a.p0.l3.a
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Context context = this.f60068e;
            if (!(context instanceof Activity) || g.e((Activity) context)) {
                super.show();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f60073a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60074b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60075c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f60076d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f60077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f60078f;

        public a(e eVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, card, onClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f60078f = eVar;
            View inflate = LayoutInflater.from(eVar.f60068e).inflate(R.layout.new_user_text_item, (ViewGroup) null);
            this.f60073a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60073a : (View) invokeV.objValue;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, card, onClickListener) == null) {
                c();
                this.f60077e.setOnClickListener(onClickListener);
                this.f60077e.setTag(card);
                this.f60074b.setText(card.getFname());
                if (card.getOrder() == 1) {
                    drawable = this.f60078f.f60068e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_rise);
                } else {
                    drawable = card.getOrder() == 2 ? this.f60078f.f60068e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_decline) : null;
                }
                this.f60074b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                this.f60075c.setText(card.getCdesc());
                d(card.getIs_like() != 0);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f60074b = (TextView) this.f60073a.findViewById(R.id.tv_fname);
                this.f60075c = (TextView) this.f60073a.findViewById(R.id.tv_cdesc);
                this.f60076d = (ImageView) this.f60073a.findViewById(R.id.iv_like);
                this.f60077e = (LinearLayout) this.f60073a.findViewById(R.id.ll_like);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (!z) {
                    this.f60076d.setBackgroundDrawable(this.f60078f.f60068e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
                } else {
                    this.f60076d.setBackgroundDrawable(this.f60078f.f60068e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
                }
            }
        }

        public a(e eVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60078f = eVar;
            this.f60073a = view;
            c();
        }
    }
}
