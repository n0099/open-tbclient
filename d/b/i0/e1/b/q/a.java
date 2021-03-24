package d.b.i0.e1.b.q;

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
import d.b.i0.d1.f.h;
/* loaded from: classes4.dex */
public class a {
    public static final String i = "d.b.i0.e1.b.q.a";

    /* renamed from: a  reason: collision with root package name */
    public View f54499a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f54500b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54501c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54502d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f54503e;

    /* renamed from: f  reason: collision with root package name */
    public View f54504f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f54505g;

    /* renamed from: h  reason: collision with root package name */
    public int f54506h = 3;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f54505g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f54499a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f54500b = headImageView;
        headImageView.setIsRound(true);
        this.f54500b.setOnClickListener(onClickListener);
        this.f54500b.setPlaceHolder(1);
        TextView textView = (TextView) this.f54499a.findViewById(R.id.tv_user_name);
        this.f54501c = textView;
        textView.setOnClickListener(onClickListener);
        this.f54502d = (TextView) this.f54499a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f54499a.findViewById(R.id.tv_content);
        this.f54503e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        d.b.h0.b1.m.a layoutStrategy = this.f54503e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f54503e.setLayoutStrategy(layoutStrategy);
        this.f54503e.setClickable(true);
        this.f54503e.setFocusable(true);
        this.f54504f = this.f54499a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        return this.f54499a;
    }

    public void b() {
        if (this.f54506h != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setBackgroundColor(this.f54499a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f54501c, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f54502d, R.color.CAM_X0109);
            this.f54503e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f54503e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            SkinManager.setBackgroundColor(this.f54504f, R.color.CAM_X0204);
            this.f54506h = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void c(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.f54500b.setUserId(chatMessage.getUserInfo().getUserId());
            this.f54500b.W(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.f54502d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
            TbPageContext tbPageContext = this.f54505g;
            if (tbPageContext == null || this.f54503e == null) {
                return;
            }
            h.e(tbPageContext.getContext(), this.f54503e, chatMessage, i, 0);
            if (chatMessage == null || chatMessage.getContent() == null) {
                return;
            }
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : split) {
                stringBuffer.append(str);
            }
            this.f54503e.setContentDescription(stringBuffer.toString());
            this.f54503e.getTextView().setContentDescription(stringBuffer.toString());
        }
    }
}
