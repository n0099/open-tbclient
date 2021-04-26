package d.a.j0.m2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import tbclient.BaijiahaoInfo;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    public static d.a.c.j.d.a t;
    public static String u;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f56801e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f56802f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f56803g;

    /* renamed from: h  reason: collision with root package name */
    public final ColumnLayout f56804h;

    /* renamed from: i  reason: collision with root package name */
    public final ColumnLayout f56805i;
    public InterfaceC1355a j;
    public int k;
    public LinearLayout l;
    public HeadImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public ImageView r;
    public TbPageContext<?> s;

    /* renamed from: d.a.j0.m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1355a {
        void a(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.s = tbPageContext;
        this.l = (LinearLayout) view.findViewById(R.id.top_line);
        this.m = (HeadImageView) view.findViewById(R.id.portrait);
        this.n = (TextView) view.findViewById(R.id.username);
        this.o = (TextView) view.findViewById(R.id.reply_time);
        this.p = (TextView) view.findViewById(R.id.forum_name);
        this.q = (TextView) view.findViewById(R.id.reply_count);
        this.f56803g = (LinearLayout) view.findViewById(R.id.item_content);
        this.f56804h = (ColumnLayout) view.findViewById(R.id.item_header);
        this.f56805i = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.f56801e = (LinearLayout) view.findViewById(R.id.person_thread);
        this.f56802f = (LinearLayout) view.findViewById(R.id.person_child);
        this.r = (ImageView) view.findViewById(R.id.comment_icon);
        this.k = d.a.c.e.p.l.e(view.getContext(), 42.0f);
        LinearLayout linearLayout = this.f56803g;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.f56804h.setOnClickListener(this);
        this.f56805i.setOnClickListener(this);
        this.q.setText(R.string.reply_me);
    }

    public void a(int i2) {
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundResource(this.f56801e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f56802f, R.color.CAM_X0201);
        TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_card_comment22, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
    }

    public final void b(String str) {
        String str2 = u;
        if (str2 != null && !str2.equals(str)) {
            t = null;
        }
        d.a.c.j.d.a aVar = t;
        if (aVar != null) {
            this.m.setImageBitmap(aVar.p());
            u = str;
            return;
        }
        HeadImageView headImageView = this.m;
        int i2 = this.k;
        headImageView.R(str, 12, i2, i2, false);
    }

    public void c(InterfaceC1355a interfaceC1355a) {
        this.j = interfaceC1355a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0009 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x009b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Type inference failed for: r13v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v11, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String[] strArr = new String[4];
        String str6 = 1000;
        str6 = 1000;
        boolean z2 = true;
        String str7 = null;
        try {
            try {
                try {
                    try {
                        if (z != 0) {
                            String str8 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String formatTime = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            str3 = postInfoList.forum_name;
                            str7 = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str6 = formatTime;
                            z = str8;
                        } else {
                            String str9 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            String formatTime2 = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            str3 = postInfoList.forum_name;
                            str7 = String.valueOf(postInfoList.reply_num);
                            str6 = formatTime2;
                            z = str9;
                        }
                    } catch (Exception unused) {
                        String str10 = str7;
                        str3 = str10;
                        str5 = str10;
                        str4 = z;
                        str7 = str4;
                        str2 = str3;
                        str6 = str5;
                        z2 = false;
                        String str11 = str7;
                        str7 = str2;
                        z = str11;
                        if (z2) {
                        }
                    }
                } catch (Exception unused2) {
                    str3 = str7;
                    str5 = str6;
                    str4 = z;
                    str7 = str4;
                    str2 = str3;
                    str6 = str5;
                    z2 = false;
                    String str112 = str7;
                    str7 = str2;
                    z = str112;
                    if (z2) {
                    }
                }
            } catch (Exception unused3) {
                str2 = null;
                str6 = 0;
                str3 = null;
                z2 = false;
                String str1122 = str7;
                str7 = str2;
                z = str1122;
                if (z2) {
                }
            }
        } catch (Exception unused4) {
            String str12 = str7;
            str7 = z;
            str2 = str12;
            str6 = str6;
            z2 = false;
            String str11222 = str7;
            str7 = str2;
            z = str11222;
            if (z2) {
            }
        }
        if (z2) {
            this.n.setText(z);
            this.o.setText(str6);
            this.p.setText(str3);
            this.p.setTag(str3);
            this.q.setText(str7);
            this.q.setTag(strArr);
            this.p.setOnClickListener(this);
            BaijiahaoInfo baijiahaoInfo = postInfoList.mBaijiahaoInfo;
            if (baijiahaoInfo != null && !StringUtils.isNull(baijiahaoInfo.avatar)) {
                b(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                b(str);
            }
            LinearLayout linearLayout = this.f56803g;
            if (linearLayout != null) {
                linearLayout.setTag(strArr);
            }
            this.f56804h.setTag(strArr);
            this.f56805i.setTag(strArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            TbPageContext<?> tbPageContext = this.s;
            if (tbPageContext != null) {
                tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.s.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
                return;
            }
            return;
        }
        InterfaceC1355a interfaceC1355a = this.j;
        if (interfaceC1355a != null) {
            interfaceC1355a.a(view);
        }
    }
}
