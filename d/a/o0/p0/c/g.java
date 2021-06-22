package d.a.o0.p0.c;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.FrsMemberHeaderViewHolder;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.o0.e3.w;
/* loaded from: classes4.dex */
public class g extends d.a.o0.r0.k<h, FrsMemberHeaderViewHolder> {
    public LikeModel w;
    public int x;
    public int y;
    public View.OnClickListener z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                d.a.c.k.e.n z = g.this.z(((Integer) tag).intValue());
                if (z instanceof h) {
                    h hVar = (h) z;
                    if (view.getId() == R.id.like_btn) {
                        if (ViewHelper.checkUpIsLogin(g.this.o.getPageActivity())) {
                            if (!d.a.c.e.p.j.z()) {
                                g.this.o.showToast(R.string.neterror);
                                return;
                            }
                            String b2 = hVar.b();
                            g.this.w.L(hVar.c(), b2);
                        }
                    } else if (view.getId() == R.id.user_level_name) {
                        String b3 = hVar.b();
                        g.this.o.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(g.this.f43012e, hVar.c(), b3)));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.a.e {
        public b() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (!(obj instanceof w) || g.this.w.getErrorCode() != 0) {
                if (AntiHelper.m(g.this.w.getErrorCode(), g.this.w.getErrorString())) {
                    AntiHelper.u(g.this.o.getPageActivity(), g.this.w.getErrorString());
                    return;
                } else {
                    g.this.o.showToast(g.this.w.getErrorString());
                    return;
                }
            }
            w wVar = (w) obj;
            wVar.v(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
        }
    }

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.x = 0;
        this.y = 0;
        this.z = new a();
    }

    public final int[] A0(int i2) {
        return i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818};
    }

    public final void B0() {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.w = likeModel;
        likeModel.setLoadDataCallBack(new b());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: C0 */
    public FrsMemberHeaderViewHolder Q(ViewGroup viewGroup) {
        if (this.w == null) {
            B0();
        }
        return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.f43012e).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.z);
    }

    public View D0(int i2, View view, ViewGroup viewGroup, h hVar, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        super.X(i2, view, viewGroup, hVar, frsMemberHeaderViewHolder);
        if (hVar != null && hVar.e() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = SkinManager.getColor(R.color.CAM_X0109);
            w e2 = hVar.e();
            if (TbadkCoreApplication.isLogin()) {
                if (e2.l() == 1) {
                    frsMemberHeaderViewHolder.f15109a.setVisibility(8);
                    frsMemberHeaderViewHolder.f15110b.setVisibility(0);
                    frsMemberHeaderViewHolder.f15110b.setText(R.string.mydegree);
                    SkinManager.setImageResource(frsMemberHeaderViewHolder.f15111c, BitmapHelper.getSmallGradeResourceIdNew(e2.k()));
                    if (StringUtils.isNull(e2.h())) {
                        frsMemberHeaderViewHolder.f15112d.setVisibility(8);
                    } else {
                        frsMemberHeaderViewHolder.f15112d.setText(e2.h());
                        frsMemberHeaderViewHolder.f15112d.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(e2.c() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + e2.i());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    frsMemberHeaderViewHolder.f15115g.setText(spannableStringBuilder);
                    frsMemberHeaderViewHolder.f15115g.setVisibility(0);
                    frsMemberHeaderViewHolder.k.setVisibility(0);
                    frsMemberHeaderViewHolder.l.setVisibility(0);
                } else {
                    frsMemberHeaderViewHolder.f15109a.setVisibility(0);
                    frsMemberHeaderViewHolder.f15110b.setVisibility(8);
                    frsMemberHeaderViewHolder.f15111c.setVisibility(8);
                    frsMemberHeaderViewHolder.f15112d.setVisibility(8);
                    frsMemberHeaderViewHolder.f15115g.setVisibility(8);
                    frsMemberHeaderViewHolder.k.setVisibility(8);
                    frsMemberHeaderViewHolder.l.setVisibility(8);
                }
            } else {
                frsMemberHeaderViewHolder.f15109a.setVisibility(8);
                frsMemberHeaderViewHolder.f15110b.setVisibility(8);
                frsMemberHeaderViewHolder.f15111c.setVisibility(8);
                frsMemberHeaderViewHolder.f15112d.setVisibility(8);
                frsMemberHeaderViewHolder.f15115g.setVisibility(8);
                frsMemberHeaderViewHolder.k.setVisibility(8);
                frsMemberHeaderViewHolder.l.setVisibility(8);
            }
            frsMemberHeaderViewHolder.f15109a.setTag(Integer.valueOf(i2));
            frsMemberHeaderViewHolder.f15112d.setTag(Integer.valueOf(i2));
            frsMemberHeaderViewHolder.f15112d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f15116h, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f15113e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f15117i, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.f15109a, R.drawable.frs_btn_like);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f15109a, R.color.white_alpha100, 1);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f15110b, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f15112d, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.k, R.drawable.forum_member_exp_progress);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.l, R.color.CAM_X0204);
            if (this.x != e2.k() || this.y != e2.c()) {
                this.x = e2.k();
                this.y = e2.c();
                frsMemberHeaderViewHolder.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, A0(this.x)));
                int c2 = e2.c();
                this.y = c2;
                if (c2 > e2.i()) {
                    this.y = e2.i();
                }
                float i3 = e2.i() != 0 ? this.y / e2.i() : 0.0f;
                if (i3 > 0.999f) {
                    i3 = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, i3, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                d.a.o0.e3.a.b((TbPageContextSupport) this.o.getPageActivity(), frsMemberHeaderViewHolder.k, scaleAnimation, null);
            }
        }
        return view;
    }

    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        D0(i2, view, viewGroup, (h) obj, (FrsMemberHeaderViewHolder) viewHolder);
        return view;
    }
}
