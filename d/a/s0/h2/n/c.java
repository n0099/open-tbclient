package d.a.s0.h2.n;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.x1;
import d.a.s0.h2.k.e.r0;
import d.a.s0.z3.i;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f60908a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60909b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60910c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60911d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60912e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60913f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60914g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadAgreeAndShareLayout f60915h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60916i;
    public boolean j;
    public boolean k;
    public d.a.r0.r.f0.q.a l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public d.a.r0.b1.m.f q;
    public View.OnClickListener r;

    /* loaded from: classes9.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60917e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60917e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f60917e;
                if (cVar.f60909b == null || cVar.m == null || this.f60917e.k || (layout = this.f60917e.f60909b.getLayout()) == null) {
                    return;
                }
                if (this.f60917e.f60916i) {
                    if (this.f60917e.j) {
                        return;
                    }
                    int lineCount = layout.getLineCount();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60917e.f60912e.getLayoutParams();
                    if (this.f60917e.f60912e.getWidth() + layout.getLineWidth(lineCount - 1) > layout.getWidth()) {
                        layoutParams.addRule(3, R.id.view_video_title);
                        layoutParams.addRule(8, 0);
                    } else {
                        layoutParams.addRule(8, R.id.view_video_title);
                        layoutParams.addRule(3, 0);
                    }
                    this.f60917e.f60912e.setLayoutParams(layoutParams);
                    this.f60917e.j = true;
                    return;
                }
                int lineCount2 = layout.getLineCount();
                if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                    if (this.f60917e.n == null) {
                        String spannableStringBuilder = this.f60917e.m.toString();
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                        int length = cutChineseAndEnglishWithSuffix.length();
                        this.f60917e.n = new SpannableStringBuilder();
                        this.f60917e.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                        for (Object obj : this.f60917e.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                            int spanStart = this.f60917e.m.getSpanStart(obj);
                            int spanEnd = this.f60917e.m.getSpanEnd(obj);
                            if (spanStart < length && spanEnd >= length) {
                                break;
                            }
                            if (obj instanceof SpannableString) {
                                this.f60917e.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                            }
                        }
                        SpannableString spannableString = new SpannableString("...展开");
                        spannableString.setSpan(this.f60917e.q, 0, spannableString.length(), 17);
                        this.f60917e.n.insert(length, (CharSequence) spannableString);
                        c cVar2 = this.f60917e;
                        cVar2.p = new i(cVar2.n);
                    }
                    this.f60917e.f60912e.setVisibility(8);
                    c cVar3 = this.f60917e;
                    cVar3.f60909b.setOnTouchListener(cVar3.p);
                    c cVar4 = this.f60917e;
                    cVar4.f60909b.setText(cVar4.n);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends d.a.r0.b1.m.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        @Override // d.a.r0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.r0.l.a.s(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
            }
        }

        @Override // d.a.r0.b1.m.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* renamed from: d.a.s0.h2.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1477c extends d.a.r0.b1.m.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1477c(c cVar, int i2, String str) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = cVar;
        }

        @Override // d.a.r0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.f60916i = true;
                this.l.f60909b.setMaxLines(10);
                c cVar = this.l;
                cVar.f60909b.setOnTouchListener(new i(cVar.m));
                c cVar2 = this.l;
                cVar2.f60909b.setText(cVar2.m);
                this.l.f60912e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60918e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60918e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f60918e.f60913f) {
                    Object tag = this.f60918e.f60913f.getTag();
                    Context context = view.getContext();
                    if (!(tag instanceof String) || context == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                    return;
                }
                c cVar = this.f60918e;
                if (view == cVar.f60912e) {
                    cVar.f60916i = false;
                    c cVar2 = this.f60918e;
                    cVar2.f60909b.setOnTouchListener(cVar2.p);
                    c cVar3 = this.f60918e;
                    cVar3.f60909b.setText(cVar3.n);
                    this.f60918e.f60912e.setVisibility(8);
                }
            }
        }
    }

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new C1477c(this, 2, null);
        this.r = new d(this);
        if (view == null) {
            return;
        }
        this.f60908a = view;
        TextView textView = (TextView) view.findViewById(R.id.view_video_title);
        this.f60909b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.f60909b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.f60909b.getPaint().setFakeBoldText(true);
        this.f60910c = (TextView) this.f60908a.findViewById(R.id.pb_video_replay_num);
        this.f60911d = (TextView) this.f60908a.findViewById(R.id.pb_video_play_count);
        this.f60912e = (TextView) this.f60908a.findViewById(R.id.view_video_title_up);
        this.f60913f = (TextView) this.f60908a.findViewById(R.id.pb_video_forum);
        this.f60915h = (ThreadAgreeAndShareLayout) this.f60908a.findViewById(R.id.pb_video_act);
        this.f60914g = (TbImageView) this.f60908a.findViewById(R.id.arrow_right);
        this.f60909b.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void m(d.a.s0.h2.h.e eVar, String str) {
        b2 N;
        x1 x1Var;
        SpannableStringBuilder spannableStringBuilder;
        Layout i2;
        SpannableString c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, eVar, str) == null) || eVar == null || (N = eVar.N()) == null || N.l1() == null) {
            return;
        }
        N.L2();
        this.m = new SpannableStringBuilder(N.b1());
        boolean n = n(N);
        VideoInfo l1 = N.l1();
        if (!StringUtils.isNull(l1.mcn_lead_page) && !n) {
            this.k = true;
        } else {
            this.k = false;
        }
        if (this.m != null && !this.k && !n && (c2 = r0.c(N)) != null) {
            d.a.r0.r.f0.q.a[] aVarArr = (d.a.r0.r.f0.q.a[]) c2.getSpans(0, c2.length(), d.a.r0.r.f0.q.a.class);
            if (aVarArr != null && aVarArr.length > 0) {
                this.l = aVarArr[0];
            }
            this.m.append((CharSequence) c2);
        }
        if (this.l != null && (spannableStringBuilder = this.m) != null && (i2 = r0.i(spannableStringBuilder)) != null && i2.getLineCount() > 10) {
            int spanStart = this.m.getSpanStart(this.l);
            int spanEnd = this.m.getSpanEnd(this.l);
            if (spanStart > 0) {
                this.m.delete(spanStart, spanEnd);
            }
        }
        if (this.k) {
            d.a.s0.h2.n.h.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.f60909b, N.b1().toString(), l1.mcn_lead_page, N.n1());
        } else {
            this.f60909b.setText(this.m);
        }
        this.f60909b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        i iVar = new i(this.m);
        this.o = iVar;
        this.f60909b.setOnTouchListener(iVar);
        this.f60912e.setOnClickListener(this.r);
        this.f60911d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), StringHelper.numberUniformFormatExtra(l1.play_count.intValue())));
        if (eVar.e0() && eVar.l0()) {
            if (TextUtils.isEmpty(str)) {
                str = N.W();
            }
            if (TextUtils.isEmpty(str) && (x1Var = (x1) ListUtils.getItem(eVar.q(), 0)) != null) {
                str = x1Var.f56096b;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f60914g.setVisibility(0);
                this.f60913f.setVisibility(0);
                this.f60913f.setOnClickListener(this.r);
                this.f60913f.setText(r0.d(str));
                this.f60913f.setTag(str);
            } else {
                this.f60913f.setVisibility(8);
                this.f60914g.setVisibility(8);
            }
            this.f60910c.setVisibility(8);
            this.f60915h.setData(eVar, N.z());
        } else {
            this.f60914g.setVisibility(8);
            this.f60913f.setVisibility(8);
            this.f60910c.setVisibility(0);
            this.f60910c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), StringHelper.numberUniformFormatExtra(N.P0())));
            this.f60915h.setVisibility(8);
        }
        o();
    }

    public final boolean n(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var)) == null) {
            if (b2Var == null || this.m == null || !b2Var.d() || StringUtils.isNull(b2Var.n1())) {
                return false;
            }
            String str = d.a.r0.r.d0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + b2Var.n1();
            this.m.append((CharSequence) b2Var.e(new b(this, 2, str, str)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f60912e, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.f60909b, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f60910c, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f60911d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f60913f, R.color.CAM_X0107, 1);
            SkinManager.setImageResource(this.f60914g, R.drawable.icon_common_arrow20_right_n);
            ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.f60915h;
            if (threadAgreeAndShareLayout != null) {
                threadAgreeAndShareLayout.j();
            }
        }
    }
}
