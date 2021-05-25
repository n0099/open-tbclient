package d.a.n0.p0.c;

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
import d.a.n0.e3.w;
/* loaded from: classes4.dex */
public class g extends d.a.n0.r0.k<h, FrsMemberHeaderViewHolder> {
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
                d.a.c.j.e.n y = g.this.y(((Integer) tag).intValue());
                if (y instanceof h) {
                    h hVar = (h) y;
                    if (view.getId() == R.id.like_btn) {
                        if (ViewHelper.checkUpIsLogin(g.this.o.getPageActivity())) {
                            if (!d.a.c.e.p.j.z()) {
                                g.this.o.showToast(R.string.neterror);
                                return;
                            }
                            String c2 = hVar.c();
                            g.this.w.H(hVar.e(), c2);
                        }
                    } else if (view.getId() == R.id.user_level_name) {
                        String c3 = hVar.c();
                        g.this.o.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(g.this.f39228e, hVar.e(), c3)));
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

    public final void A0() {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.w = likeModel;
        likeModel.setLoadDataCallBack(new b());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: B0 */
    public FrsMemberHeaderViewHolder P(ViewGroup viewGroup) {
        if (this.w == null) {
            A0();
        }
        return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.z);
    }

    public View C0(int i2, View view, ViewGroup viewGroup, h hVar, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        super.W(i2, view, viewGroup, hVar, frsMemberHeaderViewHolder);
        if (hVar != null && hVar.f() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = SkinManager.getColor(R.color.CAM_X0109);
            w f2 = hVar.f();
            if (TbadkCoreApplication.isLogin()) {
                if (f2.l() == 1) {
                    frsMemberHeaderViewHolder.f14970a.setVisibility(8);
                    frsMemberHeaderViewHolder.f14971b.setVisibility(0);
                    frsMemberHeaderViewHolder.f14971b.setText(R.string.mydegree);
                    SkinManager.setImageResource(frsMemberHeaderViewHolder.f14972c, BitmapHelper.getSmallGradeResourceIdNew(f2.k()));
                    if (StringUtils.isNull(f2.h())) {
                        frsMemberHeaderViewHolder.f14973d.setVisibility(8);
                    } else {
                        frsMemberHeaderViewHolder.f14973d.setText(f2.h());
                        frsMemberHeaderViewHolder.f14973d.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(f2.c() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + f2.i());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    frsMemberHeaderViewHolder.f14976g.setText(spannableStringBuilder);
                    frsMemberHeaderViewHolder.f14976g.setVisibility(0);
                    frsMemberHeaderViewHolder.k.setVisibility(0);
                    frsMemberHeaderViewHolder.l.setVisibility(0);
                } else {
                    frsMemberHeaderViewHolder.f14970a.setVisibility(0);
                    frsMemberHeaderViewHolder.f14971b.setVisibility(8);
                    frsMemberHeaderViewHolder.f14972c.setVisibility(8);
                    frsMemberHeaderViewHolder.f14973d.setVisibility(8);
                    frsMemberHeaderViewHolder.f14976g.setVisibility(8);
                    frsMemberHeaderViewHolder.k.setVisibility(8);
                    frsMemberHeaderViewHolder.l.setVisibility(8);
                }
            } else {
                frsMemberHeaderViewHolder.f14970a.setVisibility(8);
                frsMemberHeaderViewHolder.f14971b.setVisibility(8);
                frsMemberHeaderViewHolder.f14972c.setVisibility(8);
                frsMemberHeaderViewHolder.f14973d.setVisibility(8);
                frsMemberHeaderViewHolder.f14976g.setVisibility(8);
                frsMemberHeaderViewHolder.k.setVisibility(8);
                frsMemberHeaderViewHolder.l.setVisibility(8);
            }
            frsMemberHeaderViewHolder.f14970a.setTag(Integer.valueOf(i2));
            frsMemberHeaderViewHolder.f14973d.setTag(Integer.valueOf(i2));
            frsMemberHeaderViewHolder.f14973d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f14977h, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f14974e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f14978i, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.f14970a, R.drawable.frs_btn_like);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f14970a, R.color.white_alpha100, 1);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f14971b, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f14973d, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.k, R.drawable.forum_member_exp_progress);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.l, R.color.CAM_X0204);
            if (this.x != f2.k() || this.y != f2.c()) {
                this.x = f2.k();
                this.y = f2.c();
                frsMemberHeaderViewHolder.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, z0(this.x)));
                int c2 = f2.c();
                this.y = c2;
                if (c2 > f2.i()) {
                    this.y = f2.i();
                }
                float i3 = f2.i() != 0 ? this.y / f2.i() : 0.0f;
                if (i3 > 0.999f) {
                    i3 = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, i3, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                d.a.n0.e3.a.b((TbPageContextSupport) this.o.getPageActivity(), frsMemberHeaderViewHolder.k, scaleAnimation, null);
            }
        }
        return view;
    }

    @Override // d.a.n0.r0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        C0(i2, view, viewGroup, (h) obj, (FrsMemberHeaderViewHolder) viewHolder);
        return view;
    }

    public final int[] z0(int i2) {
        return i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818};
    }
}
