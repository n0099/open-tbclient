package d.a.q0.l3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.g;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b extends Dialog implements d.a.q0.l3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f60656e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60657f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60658g;

    /* renamed from: h  reason: collision with root package name */
    public View f60659h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f60660i;
    public View.OnClickListener j;
    public View k;
    public LinearLayout l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, int i2) {
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
        this.f60656e = context;
        f();
    }

    @Override // d.a.q0.l3.a
    public void a(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (findViewWithTag = this.f60660i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(false);
        }
    }

    @Override // d.a.q0.l3.a
    public void b(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (findViewWithTag = this.f60660i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(true);
        }
    }

    @Override // d.a.q0.l3.a
    public void c(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tag) == null) {
            this.f60657f.setText(tag.getBname());
            this.f60658g.setText(tag.getBdesc());
            ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
            int i2 = 0;
            while (i2 < card_list.size()) {
                InterestFrsData.Card card = card_list.get(i2);
                View a2 = new a(this, card, this.j).a();
                this.f60660i.addView(a2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                int dimensionPixelSize = this.f60656e.getResources().getDimensionPixelSize(R.dimen.ds20);
                layoutParams.setMargins(0, i2 == 0 ? this.f60656e.getResources().getDimensionPixelSize(R.dimen.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
                a2.setLayoutParams(layoutParams);
                if (i2 != card_list.size() - 1) {
                    this.f60660i.addView(LayoutInflater.from(this.f60656e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
                }
                ((TbImageView) this.f60660i.findViewWithTag(card.getAvatar())).M(card.getAvatar(), 10, false);
                i2++;
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            int size = (card_list.size() * getContext().getResources().getDimensionPixelSize(R.dimen.ds140)) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100);
            float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
            if (size > dimensionPixelSize2) {
                attributes.height = (int) dimensionPixelSize2;
            }
        }
    }

    @Override // d.a.q0.l3.a
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.j = onClickListener;
            this.l.setOnClickListener(onClickListener);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = View.inflate(this.f60656e, R.layout.new_user_box, null);
            this.k = inflate;
            setContentView(inflate);
            setCanceledOnTouchOutside(true);
            this.l = (LinearLayout) this.k.findViewById(R.id.box_close_layout);
            this.f60657f = (TextView) this.k.findViewById(R.id.prompt_title);
            this.f60658g = (TextView) this.k.findViewById(R.id.prompt_sub_title);
            this.f60659h = this.k.findViewById(R.id.view_layout);
            this.f60660i = (LinearLayout) findViewById(R.id.layout_content);
            this.f60659h.setBackgroundDrawable(this.f60656e.getResources().getDrawable(R.drawable.bg_startpage2_card_purple_up));
        }
    }

    @Override // d.a.q0.l3.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, d.a.q0.l3.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = this.f60656e;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f60661a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60662b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60663c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60664d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f60665e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f60666f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f60667g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f60668h;

        public a(b bVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, card, onClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f60668h = bVar;
            View inflate = LayoutInflater.from(bVar.f60656e).inflate(R.layout.new_user_rich_item, (ViewGroup) null);
            this.f60661a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60661a : (View) invokeV.objValue;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, card, onClickListener) == null) {
                c();
                this.f60667g.setOnClickListener(onClickListener);
                this.f60667g.setTag(card);
                this.f60662b.setText(card.getFname());
                this.f60663c.setText(card.getCdesc());
                this.f60664d.setText(card.getSlogan());
                this.f60666f.setTag(card.getAvatar());
                d(card.getIs_like() != 0);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f60662b = (TextView) this.f60661a.findViewById(R.id.tv_fname);
                this.f60663c = (TextView) this.f60661a.findViewById(R.id.tv_cdesc);
                this.f60665e = (ImageView) this.f60661a.findViewById(R.id.iv_like);
                this.f60664d = (TextView) this.f60661a.findViewById(R.id.tv_slogan);
                this.f60666f = (TbImageView) this.f60661a.findViewById(R.id.img);
                this.f60667g = (LinearLayout) this.f60661a.findViewById(R.id.ll_like);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (!z) {
                    this.f60665e.setBackgroundDrawable(this.f60668h.f60656e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
                } else {
                    this.f60665e.setBackgroundDrawable(this.f60668h.f60656e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
                }
            }
        }

        public a(b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60668h = bVar;
            this.f60661a = view;
            c();
        }
    }
}
