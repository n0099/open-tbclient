package d.a.q0.j1.b.q;

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
import d.a.q0.i1.f.h;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f59703i = "d.a.q0.j1.b.q.a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f59704a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f59705b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59706c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59707d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f59708e;

    /* renamed from: f  reason: collision with root package name */
    public View f59709f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f59710g;

    /* renamed from: h  reason: collision with root package name */
    public int f59711h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1102464510, "Ld/a/q0/j1/b/q/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1102464510, "Ld/a/q0/j1/b/q/a;");
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
        this.f59711h = 3;
        this.f59710g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f59704a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f59705b = headImageView;
        headImageView.setIsRound(true);
        this.f59705b.setOnClickListener(onClickListener);
        this.f59705b.setPlaceHolder(1);
        TextView textView = (TextView) this.f59704a.findViewById(R.id.tv_user_name);
        this.f59706c = textView;
        textView.setOnClickListener(onClickListener);
        this.f59707d = (TextView) this.f59704a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f59704a.findViewById(R.id.tv_content);
        this.f59708e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        d.a.p0.d1.m.a layoutStrategy = this.f59708e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f59708e.setLayoutStrategy(layoutStrategy);
        this.f59708e.setClickable(true);
        this.f59708e.setFocusable(true);
        this.f59709f = this.f59704a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59704a : (View) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f59711h == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        SkinManager.setBackgroundColor(this.f59704a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f59706c, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f59707d, R.color.CAM_X0109);
        this.f59708e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f59708e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        SkinManager.setBackgroundColor(this.f59709f, R.color.CAM_X0204);
        this.f59711h = TbadkCoreApplication.getInst().getSkinType();
    }

    public void c(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) || chatMessage.getUserInfo() == null) {
            return;
        }
        this.f59705b.setUserId(chatMessage.getUserInfo().getUserId());
        this.f59705b.M(chatMessage.getUserInfo().getPortrait(), 12, false);
        this.f59707d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
        TbPageContext tbPageContext = this.f59710g;
        if (tbPageContext == null || this.f59708e == null) {
            return;
        }
        h.e(tbPageContext.getContext(), this.f59708e, chatMessage, f59703i, 0);
        if (chatMessage == null || chatMessage.getContent() == null) {
            return;
        }
        String[] split = chatMessage.getContent().split("#");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : split) {
            stringBuffer.append(str);
        }
        this.f59708e.setContentDescription(stringBuffer.toString());
        this.f59708e.getTextView().setContentDescription(stringBuffer.toString());
    }
}
