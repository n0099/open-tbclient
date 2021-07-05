package d.a.s0.q2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BaijiahaoInfo;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static d.a.c.k.d.a t;
    public static String u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f64938e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f64939f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f64940g;

    /* renamed from: h  reason: collision with root package name */
    public final ColumnLayout f64941h;

    /* renamed from: i  reason: collision with root package name */
    public final ColumnLayout f64942i;
    public InterfaceC1649a j;
    public int k;
    public LinearLayout l;
    public HeadImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public ImageView r;
    public TbPageContext<?> s;

    /* renamed from: d.a.s0.q2.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1649a {
        void a(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = tbPageContext;
        this.l = (LinearLayout) view.findViewById(R.id.top_line);
        this.m = (HeadImageView) view.findViewById(R.id.portrait);
        this.n = (TextView) view.findViewById(R.id.username);
        this.o = (TextView) view.findViewById(R.id.reply_time);
        this.p = (TextView) view.findViewById(R.id.forum_name);
        this.q = (TextView) view.findViewById(R.id.reply_count);
        this.f64940g = (LinearLayout) view.findViewById(R.id.item_content);
        this.f64941h = (ColumnLayout) view.findViewById(R.id.item_header);
        this.f64942i = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.f64938e = (LinearLayout) view.findViewById(R.id.person_thread);
        this.f64939f = (LinearLayout) view.findViewById(R.id.person_child);
        this.r = (ImageView) view.findViewById(R.id.comment_icon);
        this.k = d.a.c.e.p.l.e(view.getContext(), 42.0f);
        LinearLayout linearLayout = this.f64940g;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.f64941h.setOnClickListener(this);
        this.f64942i.setOnClickListener(this);
        this.q.setText(R.string.reply_me);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.f64938e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f64939f, R.color.CAM_X0201);
            TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_card_comment22, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = u;
            if (str2 != null && !str2.equals(str)) {
                t = null;
            }
            d.a.c.k.d.a aVar = t;
            if (aVar != null) {
                this.m.setImageBitmap(aVar.p());
                u = str;
                return;
            }
            HeadImageView headImageView = this.m;
            int i2 = this.k;
            headImageView.J(str, 12, i2, i2, false);
        }
    }

    public void c(InterfaceC1649a interfaceC1649a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1649a) == null) {
            this.j = interfaceC1649a;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x000d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x009f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r13v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v11, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r13v12, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r13v13, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.CharSequence, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        CharSequence charSequence5;
        ?? r0 = $ic;
        if (r0 != 0) {
            charSequence = new Object[]{postInfoList, Boolean.valueOf((boolean) z), str};
            if (r0.invokeCommon(1048579, this, charSequence) != null) {
                return;
            }
        }
        String[] strArr = new String[4];
        CharSequence charSequence6 = 1000;
        charSequence6 = 1000;
        boolean z2 = true;
        CharSequence charSequence7 = null;
        try {
            try {
                try {
                    try {
                        if (z != 0) {
                            String str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String formatTime = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            String str3 = postInfoList.forum_name;
                            charSequence7 = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            charSequence6 = formatTime;
                            charSequence = str3;
                            z = str2;
                        } else {
                            String str4 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            String formatTime2 = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            String str5 = postInfoList.forum_name;
                            charSequence7 = String.valueOf(postInfoList.reply_num);
                            charSequence6 = formatTime2;
                            charSequence = str5;
                            z = str4;
                        }
                    } catch (Exception unused) {
                        charSequence2 = charSequence7;
                        charSequence5 = charSequence6;
                        charSequence4 = z;
                        charSequence7 = charSequence4;
                        charSequence3 = charSequence2;
                        charSequence6 = charSequence5;
                        charSequence = charSequence2;
                        z2 = false;
                        CharSequence charSequence8 = charSequence7;
                        charSequence7 = charSequence3;
                        z = charSequence8;
                        if (z2) {
                        }
                    }
                } catch (Exception unused2) {
                    charSequence3 = null;
                    charSequence6 = 0;
                    charSequence = 0;
                    z2 = false;
                    CharSequence charSequence82 = charSequence7;
                    charSequence7 = charSequence3;
                    z = charSequence82;
                    if (z2) {
                    }
                }
            } catch (Exception unused3) {
                CharSequence charSequence9 = charSequence7;
                charSequence7 = z;
                charSequence3 = charSequence9;
                charSequence6 = charSequence6;
                charSequence = charSequence;
                z2 = false;
                CharSequence charSequence822 = charSequence7;
                charSequence7 = charSequence3;
                z = charSequence822;
                if (z2) {
                }
            }
        } catch (Exception unused4) {
            CharSequence charSequence10 = charSequence7;
            charSequence2 = charSequence10;
            charSequence5 = charSequence10;
            charSequence4 = z;
            charSequence7 = charSequence4;
            charSequence3 = charSequence2;
            charSequence6 = charSequence5;
            charSequence = charSequence2;
            z2 = false;
            CharSequence charSequence8222 = charSequence7;
            charSequence7 = charSequence3;
            z = charSequence8222;
            if (z2) {
            }
        }
        if (z2) {
            this.n.setText(z);
            this.o.setText(charSequence6);
            this.p.setText(charSequence);
            this.p.setTag(charSequence);
            this.q.setText(charSequence7);
            this.q.setTag(strArr);
            this.p.setOnClickListener(this);
            BaijiahaoInfo baijiahaoInfo = postInfoList.mBaijiahaoInfo;
            if (baijiahaoInfo != null && !StringUtils.isNull(baijiahaoInfo.avatar)) {
                b(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                b(str);
            }
            LinearLayout linearLayout = this.f64940g;
            if (linearLayout != null) {
                linearLayout.setTag(strArr);
            }
            this.f64941h.setTag(strArr);
            this.f64942i.setTag(strArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view.getId() == R.id.forum_name) {
                TbPageContext<?> tbPageContext = this.s;
                if (tbPageContext != null) {
                    tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.s.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
                    return;
                }
                return;
            }
            InterfaceC1649a interfaceC1649a = this.j;
            if (interfaceC1649a != null) {
                interfaceC1649a.a(view);
            }
        }
    }
}
