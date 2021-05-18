package d.a.k0.f1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.k0.e1.f.h;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final String f54954i = "d.a.k0.f1.b.q.a";

    /* renamed from: a  reason: collision with root package name */
    public View f54955a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f54956b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54957c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54958d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f54959e;

    /* renamed from: f  reason: collision with root package name */
    public View f54960f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f54961g;

    /* renamed from: h  reason: collision with root package name */
    public int f54962h = 3;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f54961g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f54955a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f54956b = headImageView;
        headImageView.setIsRound(true);
        this.f54956b.setOnClickListener(onClickListener);
        this.f54956b.setPlaceHolder(1);
        TextView textView = (TextView) this.f54955a.findViewById(R.id.tv_user_name);
        this.f54957c = textView;
        textView.setOnClickListener(onClickListener);
        this.f54958d = (TextView) this.f54955a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f54955a.findViewById(R.id.tv_content);
        this.f54959e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        d.a.j0.b1.m.a layoutStrategy = this.f54959e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f54959e.setLayoutStrategy(layoutStrategy);
        this.f54959e.setClickable(true);
        this.f54959e.setFocusable(true);
        this.f54960f = this.f54955a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        return this.f54955a;
    }

    public void b() {
        if (this.f54962h != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setBackgroundColor(this.f54955a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f54957c, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f54958d, R.color.CAM_X0109);
            this.f54959e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f54959e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            SkinManager.setBackgroundColor(this.f54960f, R.color.CAM_X0204);
            this.f54962h = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void c(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.f54956b.setUserId(chatMessage.getUserInfo().getUserId());
            this.f54956b.V(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.f54958d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
            TbPageContext tbPageContext = this.f54961g;
            if (tbPageContext == null || this.f54959e == null) {
                return;
            }
            h.e(tbPageContext.getContext(), this.f54959e, chatMessage, f54954i, 0);
            if (chatMessage == null || chatMessage.getContent() == null) {
                return;
            }
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : split) {
                stringBuffer.append(str);
            }
            this.f54959e.setContentDescription(stringBuffer.toString());
            this.f54959e.getTextView().setContentDescription(stringBuffer.toString());
        }
    }
}
