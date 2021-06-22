package d.a.o0.e2.n;

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
import d.a.n0.r.q.a2;
import d.a.n0.r.q.w1;
import d.a.o0.e2.k.e.r0;
import d.a.o0.v3.i;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f57490a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57491b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57492c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57493d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57494e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57495f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f57496g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadAgreeAndShareLayout f57497h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57498i;
    public boolean j;
    public boolean k;
    public d.a.n0.r.f0.o.a l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public d.a.n0.b1.m.f q = new C1339c(2, null);
    public View.OnClickListener r = new d();

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            c cVar = c.this;
            if (cVar.f57491b == null || cVar.m == null || c.this.k || (layout = c.this.f57491b.getLayout()) == null) {
                return;
            }
            if (c.this.f57498i) {
                if (c.this.j) {
                    return;
                }
                int lineCount = layout.getLineCount();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.f57494e.getLayoutParams();
                if (c.this.f57494e.getWidth() + layout.getLineWidth(lineCount - 1) > layout.getWidth()) {
                    layoutParams.addRule(3, R.id.view_video_title);
                    layoutParams.addRule(8, 0);
                } else {
                    layoutParams.addRule(8, R.id.view_video_title);
                    layoutParams.addRule(3, 0);
                }
                c.this.f57494e.setLayoutParams(layoutParams);
                c.this.j = true;
                return;
            }
            int lineCount2 = layout.getLineCount();
            if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                if (c.this.n == null) {
                    String spannableStringBuilder = c.this.m.toString();
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                    int length = cutChineseAndEnglishWithSuffix.length();
                    c.this.n = new SpannableStringBuilder();
                    c.this.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                    for (Object obj : c.this.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                        int spanStart = c.this.m.getSpanStart(obj);
                        int spanEnd = c.this.m.getSpanEnd(obj);
                        if (spanStart < length && spanEnd >= length) {
                            break;
                        }
                        if (obj instanceof SpannableString) {
                            c.this.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                        }
                    }
                    SpannableString spannableString = new SpannableString("...展开");
                    spannableString.setSpan(c.this.q, 0, spannableString.length(), 17);
                    c.this.n.insert(length, (CharSequence) spannableString);
                    c cVar2 = c.this;
                    cVar2.p = new i(cVar2.n);
                }
                c.this.f57494e.setVisibility(8);
                c cVar3 = c.this;
                cVar3.f57491b.setOnTouchListener(cVar3.p);
                c cVar4 = c.this;
                cVar4.f57491b.setText(cVar4.n);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.n0.b1.m.f {
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2, String str, String str2) {
            super(i2, str);
            this.l = str2;
        }

        @Override // d.a.n0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.a.n0.l.a.s(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
            TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
        }

        @Override // d.a.n0.b1.m.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: d.a.o0.e2.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1339c extends d.a.n0.b1.m.f {
        public C1339c(int i2, String str) {
            super(i2, str);
        }

        @Override // d.a.n0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.f57498i = true;
            c.this.f57491b.setMaxLines(10);
            c cVar = c.this;
            cVar.f57491b.setOnTouchListener(new i(cVar.m));
            c cVar2 = c.this;
            cVar2.f57491b.setText(cVar2.m);
            c.this.f57494e.setVisibility(0);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.f57495f) {
                Object tag = c.this.f57495f.getTag();
                Context context = view.getContext();
                if (!(tag instanceof String) || context == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                return;
            }
            c cVar = c.this;
            if (view == cVar.f57494e) {
                cVar.f57498i = false;
                c cVar2 = c.this;
                cVar2.f57491b.setOnTouchListener(cVar2.p);
                c cVar3 = c.this;
                cVar3.f57491b.setText(cVar3.n);
                c.this.f57494e.setVisibility(8);
            }
        }
    }

    public c(View view) {
        if (view == null) {
            return;
        }
        this.f57490a = view;
        TextView textView = (TextView) view.findViewById(R.id.view_video_title);
        this.f57491b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.f57491b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.f57491b.getPaint().setFakeBoldText(true);
        this.f57492c = (TextView) this.f57490a.findViewById(R.id.pb_video_replay_num);
        this.f57493d = (TextView) this.f57490a.findViewById(R.id.pb_video_play_count);
        this.f57494e = (TextView) this.f57490a.findViewById(R.id.view_video_title_up);
        this.f57495f = (TextView) this.f57490a.findViewById(R.id.pb_video_forum);
        this.f57497h = (ThreadAgreeAndShareLayout) this.f57490a.findViewById(R.id.pb_video_act);
        this.f57496g = (TbImageView) this.f57490a.findViewById(R.id.arrow_right);
        this.f57491b.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public void m(d.a.o0.e2.h.e eVar, String str) {
        a2 L;
        w1 w1Var;
        SpannableStringBuilder spannableStringBuilder;
        Layout i2;
        SpannableString c2;
        if (eVar == null || (L = eVar.L()) == null || L.x1() == null) {
            return;
        }
        L.Y2();
        this.m = new SpannableStringBuilder(L.n1());
        boolean n = n(L);
        VideoInfo x1 = L.x1();
        if (!StringUtils.isNull(x1.mcn_lead_page) && !n) {
            this.k = true;
        } else {
            this.k = false;
        }
        if (this.m != null && !this.k && !n && (c2 = r0.c(L)) != null) {
            d.a.n0.r.f0.o.a[] aVarArr = (d.a.n0.r.f0.o.a[]) c2.getSpans(0, c2.length(), d.a.n0.r.f0.o.a.class);
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
            d.a.o0.e2.n.h.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.f57491b, L.n1().toString(), x1.mcn_lead_page, L.z1());
        } else {
            this.f57491b.setText(this.m);
        }
        this.f57491b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        i iVar = new i(this.m);
        this.o = iVar;
        this.f57491b.setOnTouchListener(iVar);
        this.f57494e.setOnClickListener(this.r);
        this.f57493d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), StringHelper.numberUniformFormatExtra(x1.play_count.intValue())));
        if (eVar.a0() && eVar.f0()) {
            if (TextUtils.isEmpty(str)) {
                str = L.i0();
            }
            if (TextUtils.isEmpty(str) && (w1Var = (w1) ListUtils.getItem(eVar.p(), 0)) != null) {
                str = w1Var.f53941b;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f57496g.setVisibility(0);
                this.f57495f.setVisibility(0);
                this.f57495f.setOnClickListener(this.r);
                this.f57495f.setText(r0.d(str));
                this.f57495f.setTag(str);
            } else {
                this.f57495f.setVisibility(8);
                this.f57496g.setVisibility(8);
            }
            this.f57492c.setVisibility(8);
            this.f57497h.setData(eVar, L.L());
        } else {
            this.f57496g.setVisibility(8);
            this.f57495f.setVisibility(8);
            this.f57492c.setVisibility(0);
            this.f57492c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), StringHelper.numberUniformFormatExtra(L.b1())));
            this.f57497h.setVisibility(8);
        }
        o();
    }

    public final boolean n(a2 a2Var) {
        if (a2Var == null || this.m == null || !a2Var.A() || StringUtils.isNull(a2Var.z1())) {
            return false;
        }
        String str = d.a.n0.r.d0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + a2Var.z1();
        this.m.append((CharSequence) a2Var.B(new b(this, 2, str, str)));
        return true;
    }

    public void o() {
        SkinManager.setViewTextColor(this.f57494e, R.color.CAM_X0304, 1);
        SkinManager.setViewTextColor(this.f57491b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f57492c, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f57493d, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f57495f, R.color.CAM_X0107, 1);
        SkinManager.setImageResource(this.f57496g, R.drawable.icon_common_arrow20_right_n);
        ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.f57497h;
        if (threadAgreeAndShareLayout != null) {
            threadAgreeAndShareLayout.j();
        }
    }
}
