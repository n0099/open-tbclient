package d.a.p0.h2.n;

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
import d.a.o0.r.q.b2;
import d.a.o0.r.q.x1;
import d.a.p0.h2.k.e.r0;
import d.a.p0.z3.i;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f57664a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57665b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57666c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57667d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57668e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57669f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f57670g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadAgreeAndShareLayout f57671h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57672i;
    public boolean j;
    public boolean k;
    public d.a.o0.r.f0.r.a l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public d.a.o0.b1.m.f q;
    public View.OnClickListener r;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57673e;

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
            this.f57673e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f57673e;
                if (cVar.f57665b == null || cVar.m == null || this.f57673e.k || (layout = this.f57673e.f57665b.getLayout()) == null) {
                    return;
                }
                if (this.f57673e.f57672i) {
                    if (this.f57673e.j) {
                        return;
                    }
                    int lineCount = layout.getLineCount();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f57673e.f57668e.getLayoutParams();
                    if (this.f57673e.f57668e.getWidth() + layout.getLineWidth(lineCount - 1) > layout.getWidth()) {
                        layoutParams.addRule(3, R.id.view_video_title);
                        layoutParams.addRule(8, 0);
                    } else {
                        layoutParams.addRule(8, R.id.view_video_title);
                        layoutParams.addRule(3, 0);
                    }
                    this.f57673e.f57668e.setLayoutParams(layoutParams);
                    this.f57673e.j = true;
                    return;
                }
                int lineCount2 = layout.getLineCount();
                if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                    if (this.f57673e.n == null) {
                        String spannableStringBuilder = this.f57673e.m.toString();
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                        int length = cutChineseAndEnglishWithSuffix.length();
                        this.f57673e.n = new SpannableStringBuilder();
                        this.f57673e.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                        for (Object obj : this.f57673e.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                            int spanStart = this.f57673e.m.getSpanStart(obj);
                            int spanEnd = this.f57673e.m.getSpanEnd(obj);
                            if (spanStart < length && spanEnd >= length) {
                                break;
                            }
                            if (obj instanceof SpannableString) {
                                this.f57673e.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                            }
                        }
                        SpannableString spannableString = new SpannableString("...展开");
                        spannableString.setSpan(this.f57673e.q, 0, spannableString.length(), 17);
                        this.f57673e.n.insert(length, (CharSequence) spannableString);
                        c cVar2 = this.f57673e;
                        cVar2.p = new i(cVar2.n);
                    }
                    this.f57673e.f57668e.setVisibility(8);
                    c cVar3 = this.f57673e;
                    cVar3.f57665b.setOnTouchListener(cVar3.p);
                    c cVar4 = this.f57673e;
                    cVar4.f57665b.setText(cVar4.n);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.o0.b1.m.f {
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

        @Override // d.a.o0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.o0.l.a.s(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
            }
        }

        @Override // d.a.o0.b1.m.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* renamed from: d.a.p0.h2.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1432c extends d.a.o0.b1.m.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1432c(c cVar, int i2, String str) {
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

        @Override // d.a.o0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.f57672i = true;
                this.l.f57665b.setMaxLines(10);
                c cVar = this.l;
                cVar.f57665b.setOnTouchListener(new i(cVar.m));
                c cVar2 = this.l;
                cVar2.f57665b.setText(cVar2.m);
                this.l.f57668e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57674e;

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
            this.f57674e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f57674e.f57669f) {
                    Object tag = this.f57674e.f57669f.getTag();
                    Context context = view.getContext();
                    if (!(tag instanceof String) || context == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                    return;
                }
                c cVar = this.f57674e;
                if (view == cVar.f57668e) {
                    cVar.f57672i = false;
                    c cVar2 = this.f57674e;
                    cVar2.f57665b.setOnTouchListener(cVar2.p);
                    c cVar3 = this.f57674e;
                    cVar3.f57665b.setText(cVar3.n);
                    this.f57674e.f57668e.setVisibility(8);
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
        this.q = new C1432c(this, 2, null);
        this.r = new d(this);
        if (view == null) {
            return;
        }
        this.f57664a = view;
        TextView textView = (TextView) view.findViewById(R.id.view_video_title);
        this.f57665b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.f57665b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.f57665b.getPaint().setFakeBoldText(true);
        this.f57666c = (TextView) this.f57664a.findViewById(R.id.pb_video_replay_num);
        this.f57667d = (TextView) this.f57664a.findViewById(R.id.pb_video_play_count);
        this.f57668e = (TextView) this.f57664a.findViewById(R.id.view_video_title_up);
        this.f57669f = (TextView) this.f57664a.findViewById(R.id.pb_video_forum);
        this.f57671h = (ThreadAgreeAndShareLayout) this.f57664a.findViewById(R.id.pb_video_act);
        this.f57670g = (TbImageView) this.f57664a.findViewById(R.id.arrow_right);
        this.f57665b.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void m(d.a.p0.h2.h.e eVar, String str) {
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
            d.a.o0.r.f0.r.a[] aVarArr = (d.a.o0.r.f0.r.a[]) c2.getSpans(0, c2.length(), d.a.o0.r.f0.r.a.class);
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
            d.a.p0.h2.n.h.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.f57665b, N.b1().toString(), l1.mcn_lead_page, N.n1());
        } else {
            this.f57665b.setText(this.m);
        }
        this.f57665b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        i iVar = new i(this.m);
        this.o = iVar;
        this.f57665b.setOnTouchListener(iVar);
        this.f57668e.setOnClickListener(this.r);
        this.f57667d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), StringHelper.numberUniformFormatExtra(l1.play_count.intValue())));
        if (eVar.e0() && eVar.l0()) {
            if (TextUtils.isEmpty(str)) {
                str = N.W();
            }
            if (TextUtils.isEmpty(str) && (x1Var = (x1) ListUtils.getItem(eVar.q(), 0)) != null) {
                str = x1Var.f52815b;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f57670g.setVisibility(0);
                this.f57669f.setVisibility(0);
                this.f57669f.setOnClickListener(this.r);
                this.f57669f.setText(r0.d(str));
                this.f57669f.setTag(str);
            } else {
                this.f57669f.setVisibility(8);
                this.f57670g.setVisibility(8);
            }
            this.f57666c.setVisibility(8);
            this.f57671h.setData(eVar, N.z());
        } else {
            this.f57670g.setVisibility(8);
            this.f57669f.setVisibility(8);
            this.f57666c.setVisibility(0);
            this.f57666c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), StringHelper.numberUniformFormatExtra(N.P0())));
            this.f57671h.setVisibility(8);
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
            String str = d.a.o0.r.d0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + b2Var.n1();
            this.m.append((CharSequence) b2Var.e(new b(this, 2, str, str)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f57668e, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.f57665b, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f57666c, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57667d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57669f, R.color.CAM_X0107, 1);
            SkinManager.setImageResource(this.f57670g, R.drawable.icon_common_arrow20_right_n);
            ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.f57671h;
            if (threadAgreeAndShareLayout != null) {
                threadAgreeAndShareLayout.j();
            }
        }
    }
}
