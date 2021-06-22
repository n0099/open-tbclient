package d.a.o0;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
@JvmName(name = "PrivacyPolicyDialogUtil")
/* loaded from: classes4.dex */
public final class j {

    /* loaded from: classes4.dex */
    public static final class a extends i {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f59622e;

        public a(Context context) {
            this.f59622e = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            d.a.n0.l.a.j(this.f59622e, "http://tieba.baidu.com/tb/cms/client/wise_secretright.html");
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends i {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f59623e;

        public b(Context context) {
            this.f59623e = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            d.a.n0.l.a.j(this.f59623e, "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
        }
    }

    public static final d.a.n0.r.s.a a(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener, int i2, int i3) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.privacy_prolicy_guide_dialog, (ViewGroup) null);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(tbPa…olicy_guide_dialog, null)");
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.title);
        eMTextView.setText(R.string.secret_hint_head);
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(eMTextView);
        d2.x(R.string.F_X02);
        d2.w(R.dimen.T_X05);
        EMTextView contentTextView = (EMTextView) inflate.findViewById(R.id.content);
        Intrinsics.checkExpressionValueIsNotNull(contentTextView, "contentTextView");
        contentTextView.setHighlightColor(0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = tbPageContext.getString(i2);
        Intrinsics.checkExpressionValueIsNotNull(string, "tbPageContext.getString(contentTestResId)");
        String format = String.format(string, Arrays.copyOf(new Object[]{tbPageContext.getString(R.string.privacy_policy_text), tbPageContext.getString(R.string.user_protocol_text)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        Activity pageActivity = tbPageContext.getPageActivity();
        Intrinsics.checkExpressionValueIsNotNull(pageActivity, "tbPageContext.pageActivity");
        SpannableString d3 = d(pageActivity, format);
        contentTextView.setMovementMethod(LinkMovementMethod.getInstance());
        contentTextView.setText(d3);
        d.a.n0.r.u.c.d(contentTextView).w(R.dimen.T_X07);
        EMTextView eMTextView2 = (EMTextView) inflate.findViewById(R.id.browseBtn);
        eMTextView2.setText(i3);
        d.a.n0.r.u.c.d(eMTextView2).w(R.dimen.T_X08);
        eMTextView2.setOnClickListener(onClickListener);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.yesBtn);
        tBSpecificationBtn.setText(tbPageContext.getString(R.string.secret_hint_agree_and_go_on));
        tBSpecificationBtn.setTextSize(R.dimen.T_X07);
        d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
        bVar.o(R.color.CAM_X0303, R.color.CAM_X0101);
        tBSpecificationBtn.setConfig(bVar);
        tBSpecificationBtn.setOnClickListener(onClickListener);
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(tbPageContext.getPageActivity());
        aVar.setContentView(inflate);
        aVar.setContentViewSize(8);
        aVar.setAutoNight(false);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.create(tbPageContext);
        return aVar;
    }

    public static final d.a.n0.r.s.a b(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(tbPa…rivate_hint_dialog, null)");
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        View protocolLayout = inflate.findViewById(R.id.protocol_layout);
        Intrinsics.checkExpressionValueIsNotNull(protocolLayout, "protocolLayout");
        protocolLayout.setVisibility(0);
        TextView scrollableTextView = (TextView) inflate.findViewById(R.id.protocol_scrollable_textview);
        Intrinsics.checkExpressionValueIsNotNull(scrollableTextView, "scrollableTextView");
        scrollableTextView.setHighlightColor(0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = tbPageContext.getString(R.string.secret_hint_format);
        Intrinsics.checkExpressionValueIsNotNull(string, "tbPageContext.getString(…tring.secret_hint_format)");
        String format = String.format(string, Arrays.copyOf(new Object[]{tbPageContext.getString(R.string.secret_hint_footer), tbPageContext.getString(R.string.secret_hint_title), tbPageContext.getString(R.string.secret_hint_content_1), tbPageContext.getString(R.string.secret_hint_content_2), tbPageContext.getString(R.string.secret_hint_content_3), tbPageContext.getString(R.string.secret_hint_content_4)}, 6));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        Activity pageActivity = tbPageContext.getPageActivity();
        Intrinsics.checkExpressionValueIsNotNull(pageActivity, "tbPageContext.pageActivity");
        SpannableString d2 = d(pageActivity, format);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            d2.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        scrollableTextView.setMovementMethod(LinkMovementMethod.getInstance());
        scrollableTextView.setText(d2);
        TextView textView = (TextView) inflate.findViewById(R.id.private_no);
        textView.setOnClickListener(onClickListener);
        int i2 = R.color.CAM_X0110;
        SkinManager.setViewTextColorSelector(textView, i2, i2, 0);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        textView2.setOnClickListener(onClickListener);
        d.a.n0.r.u.c d3 = d.a.n0.r.u.c.d(textView2);
        d3.m(R.string.J_X01);
        d3.f(R.color.CAM_X0303);
        SkinManager.setViewTextColorSelector(textView2, R.color.CAM_X0101, R.color.CAM_X0618, 0);
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(tbPageContext.getPageActivity());
        aVar.setContentView(inflate);
        aVar.setContentViewSize(7);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setAutoNight(false);
        aVar.setCancelable(false);
        aVar.create(tbPageContext);
        return aVar;
    }

    public static final int[] c(String str, int i2) {
        String patternText = TbadkCoreApplication.getInst().getString(i2);
        Intrinsics.checkExpressionValueIsNotNull(patternText, "patternText");
        int[] iArr = {StringsKt__StringsKt.indexOf$default((CharSequence) str, patternText, 0, false, 6, (Object) null), iArr[0] + patternText.length()};
        return iArr;
    }

    public static final SpannableString d(Context context, String str) {
        SpannableString spannableString = new SpannableString(str);
        int[] c2 = c(str, R.string.privacy_policy_text);
        if (c2[0] != -1) {
            spannableString.setSpan(new a(context), c2[0], c2[1], 18);
        }
        int[] c3 = c(str, R.string.user_protocol_text);
        if (c3[0] != -1) {
            spannableString.setSpan(new b(context), c3[0], c3[1], 18);
        }
        return spannableString;
    }
}
