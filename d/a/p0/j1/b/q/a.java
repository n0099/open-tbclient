package d.a.p0.j1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.i1.f.h;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f59089i = "d.a.p0.j1.b.q.a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f59090a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f59091b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59092c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59093d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f59094e;

    /* renamed from: f  reason: collision with root package name */
    public View f59095f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f59096g;

    /* renamed from: h  reason: collision with root package name */
    public int f59097h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1231547229, "Ld/a/p0/j1/b/q/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1231547229, "Ld/a/p0/j1/b/q/a;");
        }
    }

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59097h = 3;
        this.f59096g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f59090a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f59091b = headImageView;
        headImageView.setIsRound(true);
        this.f59091b.setOnClickListener(onClickListener);
        this.f59091b.setPlaceHolder(1);
        TextView textView = (TextView) this.f59090a.findViewById(R.id.tv_user_name);
        this.f59092c = textView;
        textView.setOnClickListener(onClickListener);
        this.f59093d = (TextView) this.f59090a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f59090a.findViewById(R.id.tv_content);
        this.f59094e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        d.a.o0.b1.m.a layoutStrategy = this.f59094e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f59094e.setLayoutStrategy(layoutStrategy);
        this.f59094e.setClickable(true);
        this.f59094e.setFocusable(true);
        this.f59095f = this.f59090a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59090a : (View) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f59097h == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        SkinManager.setBackgroundColor(this.f59090a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f59092c, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f59093d, R.color.CAM_X0109);
        this.f59094e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f59094e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        SkinManager.setBackgroundColor(this.f59095f, R.color.CAM_X0204);
        this.f59097h = TbadkCoreApplication.getInst().getSkinType();
    }

    public void c(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) || chatMessage.getUserInfo() == null) {
            return;
        }
        this.f59091b.setUserId(chatMessage.getUserInfo().getUserId());
        this.f59091b.M(chatMessage.getUserInfo().getPortrait(), 12, false);
        this.f59093d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
        TbPageContext tbPageContext = this.f59096g;
        if (tbPageContext == null || this.f59094e == null) {
            return;
        }
        h.e(tbPageContext.getContext(), this.f59094e, chatMessage, f59089i, 0);
        if (chatMessage == null || chatMessage.getContent() == null) {
            return;
        }
        String[] split = chatMessage.getContent().split("#");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : split) {
            stringBuffer.append(str);
        }
        this.f59094e.setContentDescription(stringBuffer.toString());
        this.f59094e.getTextView().setContentDescription(stringBuffer.toString());
    }
}
