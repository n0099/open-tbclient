package d.a.n0.r0.g1;

import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62286a;

    /* renamed from: b  reason: collision with root package name */
    public String f62287b;

    /* renamed from: c  reason: collision with root package name */
    public String f62288c;

    /* renamed from: d  reason: collision with root package name */
    public String f62289d;

    /* renamed from: e  reason: collision with root package name */
    public String f62290e;

    /* renamed from: f  reason: collision with root package name */
    public String f62291f;

    /* renamed from: g  reason: collision with root package name */
    public String f62292g;

    /* renamed from: h  reason: collision with root package name */
    public String f62293h;

    /* renamed from: i  reason: collision with root package name */
    public String f62294i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;

    public b(TbPageContext tbPageContext) {
        this.f62286a = tbPageContext;
    }

    public final SpannableStringBuilder a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) ("忍不住想告诉你个好消息，" + str + "吧的成员数量突破了"));
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("人");
        spannableStringBuilder.append((CharSequence) d(sb.toString()));
        spannableStringBuilder.append((CharSequence) ("！作为吧主，我邀请你加入" + str + "吧！\n\n"));
        spannableStringBuilder.append((CharSequence) "在我担任吧主的这");
        spannableStringBuilder.append((CharSequence) d(str3 + "天"));
        spannableStringBuilder.append((CharSequence) ("，为" + str + "吧创造了良好的社区氛围，近期发现了"));
        spannableStringBuilder.append((CharSequence) i(str4));
        spannableStringBuilder.append((CharSequence) "篇优质贴子，最火热的一篇");
        spannableStringBuilder.append((CharSequence) d("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "竟然盖了");
        spannableStringBuilder.append((CharSequence) d(str7 + "层"));
        spannableStringBuilder.append((CharSequence) "楼。\n\n");
        spannableStringBuilder.append((CharSequence) "我很喜欢");
        spannableStringBuilder.append((CharSequence) i(str));
        spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "给你安利一个有趣的社区——");
        spannableStringBuilder.append((CharSequence) (str + "吧！现在成员数已经突破"));
        spannableStringBuilder.append((CharSequence) d(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "了！\n\n");
        spannableStringBuilder.append((CharSequence) "我加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) d(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，近期发表了");
        spannableStringBuilder.append((CharSequence) i(str4));
        spannableStringBuilder.append((CharSequence) "篇贴子，最火的一篇");
        spannableStringBuilder.append((CharSequence) d("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "收到了");
        spannableStringBuilder.append((CharSequence) d(str7 + "条"));
        spannableStringBuilder.append((CharSequence) "回复、");
        spannableStringBuilder.append((CharSequence) d(str8 + "个"));
        spannableStringBuilder.append((CharSequence) "赞！\n\n");
        spannableStringBuilder.append((CharSequence) "我很喜欢");
        spannableStringBuilder.append((CharSequence) i(str));
        spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder c(String str, String str2, String str3, String str4, String str5, String str6) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "给你安利一个有趣的社区——");
        spannableStringBuilder.append((CharSequence) (str + "吧！现在成员数已经突破"));
        spannableStringBuilder.append((CharSequence) d(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "了！\n\n");
        spannableStringBuilder.append((CharSequence) "我加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) d(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，近期参与了");
        spannableStringBuilder.append((CharSequence) i(str4));
        spannableStringBuilder.append((CharSequence) "主题贴的讨论，写了");
        spannableStringBuilder.append((CharSequence) d(str5 + "条"));
        spannableStringBuilder.append((CharSequence) "评论。\n\n");
        spannableStringBuilder.append((CharSequence) "我很喜欢");
        spannableStringBuilder.append((CharSequence) i(str));
        spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
        return spannableStringBuilder;
    }

    public final SpannableString d(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), 0, spannableString.length(), 33);
        return spannableString;
    }

    public final SpannableStringBuilder e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (str + "吧成员数突破了"));
        spannableStringBuilder.append((CharSequence) d(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "！感谢你的一路相伴，见证了这个特别的时刻。\n\n你加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) d(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，最近发表了");
        spannableStringBuilder.append((CharSequence) i(str4));
        spannableStringBuilder.append((CharSequence) "篇贴子，最火的一篇");
        spannableStringBuilder.append((CharSequence) d("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "收到了");
        spannableStringBuilder.append((CharSequence) d(str7 + "条"));
        spannableStringBuilder.append((CharSequence) "回复、");
        spannableStringBuilder.append((CharSequence) d(str8 + "个"));
        spannableStringBuilder.append((CharSequence) "赞！近一个月累计签到了");
        spannableStringBuilder.append((CharSequence) (str9 + "天"));
        spannableStringBuilder.append((CharSequence) "。\n\n");
        spannableStringBuilder.append((CharSequence) (str + "吧因为有你而精彩！"));
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder f(String str, String str2, String str3, String str4, String str5, String str6) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (str + "吧成员数突破了"));
        spannableStringBuilder.append((CharSequence) d(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "！感谢你的一路相伴，见证了这个特别的时刻。\n\n你加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) d(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，近期参与了");
        spannableStringBuilder.append((CharSequence) i(str4));
        spannableStringBuilder.append((CharSequence) "个主题贴的讨论，写了");
        spannableStringBuilder.append((CharSequence) d(str5 + "条"));
        spannableStringBuilder.append((CharSequence) "评论。近一个月累计签到了");
        spannableStringBuilder.append((CharSequence) (str6 + "天。\n\n"));
        spannableStringBuilder.append((CharSequence) (str + "吧因为有你而精彩！"));
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder g(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) ("恭喜！" + str + "吧成员数突破"));
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("人");
        spannableStringBuilder.append((CharSequence) d(sb.toString()));
        spannableStringBuilder.append((CharSequence) "！\n\n");
        spannableStringBuilder.append((CharSequence) "感谢你在过去");
        spannableStringBuilder.append((CharSequence) d(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "的辛勤付出，火眼金睛的你最近挑选出了");
        spannableStringBuilder.append((CharSequence) i(str4));
        spannableStringBuilder.append((CharSequence) "篇精品贴子，处理了大量违规内容。\n\n衷心感谢你为吧友提供了和谐快乐的社区氛围。截止目前");
        spannableStringBuilder.append((CharSequence) i(str));
        spannableStringBuilder.append((CharSequence) "吧共有");
        spannableStringBuilder.append((CharSequence) d(str5 + "篇"));
        spannableStringBuilder.append((CharSequence) "贴子，最火热的一篇贴子");
        spannableStringBuilder.append((CharSequence) d("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "竟然盖了");
        spannableStringBuilder.append((CharSequence) d(str7 + "层"));
        spannableStringBuilder.append((CharSequence) "楼。\n\n继续加油吧！期望你能带领");
        spannableStringBuilder.append((CharSequence) i(str));
        spannableStringBuilder.append((CharSequence) "吧走得更远！");
        return spannableStringBuilder;
    }

    public SpannableStringBuilder h() {
        String str = this.m;
        if (str == null) {
            return null;
        }
        if (str.equals("bazhu")) {
            return a(this.f62291f, this.f62292g, this.f62293h, this.f62294i, this.j, this.k, this.l);
        }
        if (this.m.equals("active-a")) {
            return b(this.f62291f, this.f62292g, this.n, this.o, this.j, this.k, this.p, this.q, this.r);
        }
        if (this.m.equals("active-b")) {
            return c(this.f62291f, this.f62292g, this.n, this.s, this.t, this.r);
        }
        return null;
    }

    public final String i(String str) {
        return str == null ? "" : str;
    }

    public SpannableStringBuilder j() {
        String str = this.m;
        if (str == null) {
            return null;
        }
        if (str.equals("bazhu")) {
            return g(this.f62291f, this.f62292g, this.f62293h, this.f62294i, this.j, this.k, this.l);
        }
        if (this.m.equals("active-a")) {
            return e(this.f62291f, this.f62292g, this.n, this.o, this.j, this.k, this.p, this.q, this.r);
        }
        if (this.m.equals("active-b")) {
            return f(this.f62291f, this.f62292g, this.n, this.s, this.t, this.r);
        }
        return null;
    }

    public void k() {
        Uri parse;
        if (this.f62286a.getPageActivity() == null || this.f62286a.getPageActivity().getIntent() == null) {
            return;
        }
        this.f62287b = this.f62286a.getPageActivity().getIntent().getStringExtra("key_url");
        this.f62288c = this.f62286a.getPageActivity().getIntent().getStringExtra(AchievementActivityConfig.KEY_SHARE_URL);
        if (TextUtils.isEmpty(this.f62287b) || (parse = Uri.parse(this.f62287b)) == null) {
            return;
        }
        this.f62289d = parse.getQueryParameter("nickname");
        this.f62290e = parse.getQueryParameter("fid");
        this.f62291f = parse.getQueryParameter("fname");
        this.f62292g = parse.getQueryParameter("subcribe-num");
        this.f62293h = parse.getQueryParameter("bazhu-days");
        this.f62294i = parse.getQueryParameter("goods-num");
        this.j = parse.getQueryParameter("tid-num");
        String queryParameter = parse.getQueryParameter("most-hot-name");
        this.k = queryParameter;
        this.k = StringHelper.cutStringWithSuffix(queryParameter, 20, StringHelper.STRING_MORE);
        this.l = parse.getQueryParameter("most-hot-floors");
        this.m = parse.getQueryParameter("achievement");
        this.n = parse.getQueryParameter("join-days");
        this.o = parse.getQueryParameter("send-tids");
        this.p = parse.getQueryParameter("reply-num");
        this.q = parse.getQueryParameter("zan-num");
        this.r = parse.getQueryParameter("sign-days");
        this.s = parse.getQueryParameter("join-topicnum");
        this.t = parse.getQueryParameter("write-num");
    }
}
