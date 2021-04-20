package d.b.i0.f1.b.q;

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
import d.b.i0.e1.f.h;
/* loaded from: classes4.dex */
public class a {
    public static final String i = "d.b.i0.f1.b.q.a";

    /* renamed from: a  reason: collision with root package name */
    public View f55941a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f55942b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55943c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55944d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f55945e;

    /* renamed from: f  reason: collision with root package name */
    public View f55946f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f55947g;

    /* renamed from: h  reason: collision with root package name */
    public int f55948h = 3;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f55947g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f55941a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f55942b = headImageView;
        headImageView.setIsRound(true);
        this.f55942b.setOnClickListener(onClickListener);
        this.f55942b.setPlaceHolder(1);
        TextView textView = (TextView) this.f55941a.findViewById(R.id.tv_user_name);
        this.f55943c = textView;
        textView.setOnClickListener(onClickListener);
        this.f55944d = (TextView) this.f55941a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f55941a.findViewById(R.id.tv_content);
        this.f55945e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        d.b.h0.b1.m.a layoutStrategy = this.f55945e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f55945e.setLayoutStrategy(layoutStrategy);
        this.f55945e.setClickable(true);
        this.f55945e.setFocusable(true);
        this.f55946f = this.f55941a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        return this.f55941a;
    }

    public void b() {
        if (this.f55948h != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setBackgroundColor(this.f55941a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f55943c, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f55944d, R.color.CAM_X0109);
            this.f55945e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f55945e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            SkinManager.setBackgroundColor(this.f55946f, R.color.CAM_X0204);
            this.f55948h = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void c(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.f55942b.setUserId(chatMessage.getUserInfo().getUserId());
            this.f55942b.W(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.f55944d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
            TbPageContext tbPageContext = this.f55947g;
            if (tbPageContext == null || this.f55945e == null) {
                return;
            }
            h.e(tbPageContext.getContext(), this.f55945e, chatMessage, i, 0);
            if (chatMessage == null || chatMessage.getContent() == null) {
                return;
            }
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : split) {
                stringBuffer.append(str);
            }
            this.f55945e.setContentDescription(stringBuffer.toString());
            this.f55945e.getTextView().setContentDescription(stringBuffer.toString());
        }
    }
}
