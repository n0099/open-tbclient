package d.a.n0.g1.b.q;

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
import d.a.n0.f1.f.h;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final String f55142i = "d.a.n0.g1.b.q.a";

    /* renamed from: a  reason: collision with root package name */
    public View f55143a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f55144b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55145c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55146d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f55147e;

    /* renamed from: f  reason: collision with root package name */
    public View f55148f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f55149g;

    /* renamed from: h  reason: collision with root package name */
    public int f55150h = 3;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f55149g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f55143a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f55144b = headImageView;
        headImageView.setIsRound(true);
        this.f55144b.setOnClickListener(onClickListener);
        this.f55144b.setPlaceHolder(1);
        TextView textView = (TextView) this.f55143a.findViewById(R.id.tv_user_name);
        this.f55145c = textView;
        textView.setOnClickListener(onClickListener);
        this.f55146d = (TextView) this.f55143a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f55143a.findViewById(R.id.tv_content);
        this.f55147e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        d.a.m0.b1.m.a layoutStrategy = this.f55147e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f55147e.setLayoutStrategy(layoutStrategy);
        this.f55147e.setClickable(true);
        this.f55147e.setFocusable(true);
        this.f55148f = this.f55143a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        return this.f55143a;
    }

    public void b() {
        if (this.f55150h != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setBackgroundColor(this.f55143a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f55145c, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f55146d, R.color.CAM_X0109);
            this.f55147e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f55147e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            SkinManager.setBackgroundColor(this.f55148f, R.color.CAM_X0204);
            this.f55150h = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void c(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.f55144b.setUserId(chatMessage.getUserInfo().getUserId());
            this.f55144b.V(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.f55146d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
            TbPageContext tbPageContext = this.f55149g;
            if (tbPageContext == null || this.f55147e == null) {
                return;
            }
            h.e(tbPageContext.getContext(), this.f55147e, chatMessage, f55142i, 0);
            if (chatMessage == null || chatMessage.getContent() == null) {
                return;
            }
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : split) {
                stringBuffer.append(str);
            }
            this.f55147e.setContentDescription(stringBuffer.toString());
            this.f55147e.getTextView().setContentDescription(stringBuffer.toString());
        }
    }
}
