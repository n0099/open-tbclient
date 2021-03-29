package d.b.i0.c2.k;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.b.e.p.l;
import d.b.h0.b.d;
import d.b.h0.r.q.a2;
import d.b.h0.r.u.c;
import d.b.h0.t.f;
import d.b.h0.z0.i0;
import d.b.i0.c2.h.e;
import d.b.i0.c2.k.e.p0;
import d.b.i0.x.m;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static SparseIntArray f52500a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f52501b;

    static {
        new SparseArray();
        f52500a = new SparseIntArray();
        f52501b = i(R.dimen.tbds16);
    }

    public static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView == null || view == null) {
            return;
        }
        int k = (((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int i = k - (z ? i(R.dimen.tbds90) : 0);
        tbRichTextView.getLayoutStrategy().q(i);
        tbRichTextView.getLayoutStrategy().D = i - i(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f));
    }

    public static void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z) {
        if (!TextUtils.isEmpty(postData.t()) && z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
            layoutParams.topMargin = i(R.dimen.ds20);
            layoutParams.bottomMargin = i(R.dimen.ds20);
            pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.m.a0(postData.t());
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
            layoutParams2.bottomMargin = 0;
            layoutParams2.topMargin = 0;
            pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.m.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.m.a0(null);
        }
        pbCommenFloorItemViewHolder.m.setTextViewCheckSelection(false);
    }

    public static void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z, boolean z2) {
        ImageView imageView = pbCommenFloorItemViewHolder.t;
        if (imageView == null || postData == null) {
            return;
        }
        if (z2) {
            imageView.setVisibility(8);
            if (z) {
                pbCommenFloorItemViewHolder.B.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
                return;
            }
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public static void d(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, a2 a2Var) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.z() > 0 && a2Var != null && !a2Var.S1()) {
            String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.z()));
            pbCommenFloorItemViewHolder.D.setVisibility(0);
            pbCommenFloorItemViewHolder.D.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.D.setVisibility(8);
            z = false;
        }
        f H = postData.H();
        z2 = (H == null || StringUtils.isNull(H.b()) || a2Var == null || a2Var.S1()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.f19537h.setVisibility(0);
            i = f52501b;
        } else {
            pbCommenFloorItemViewHolder.f19537h.setVisibility(8);
            i = 0;
        }
        if (z2) {
            pbCommenFloorItemViewHolder.i.setVisibility(0);
            i2 = f52501b;
        } else {
            pbCommenFloorItemViewHolder.i.setVisibility(8);
            i2 = 0;
        }
        pbCommenFloorItemViewHolder.f19536g.setPadding(i, 0, i2, 0);
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.Q()), "yyyy"))) {
            pbCommenFloorItemViewHolder.f19536g.setText(StringHelper.getFormatTimeShort(postData.Q()));
        } else {
            pbCommenFloorItemViewHolder.f19536g.setText(StringHelper.getFormatTime(postData.Q()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.j.setVisibility(0);
            pbCommenFloorItemViewHolder.j.setPadding(f52501b, 0, 0, 0);
            pbCommenFloorItemViewHolder.j.setText(H.b());
            return;
        }
        pbCommenFloorItemViewHolder.j.setVisibility(8);
    }

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, a2 a2Var, int i, boolean z) {
        if (pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        if (a2Var != null) {
            postData.q().threadId = a2Var.w1();
            postData.q().forumId = String.valueOf(a2Var.c0());
        }
        if (i == 0) {
            postData.q().objType = 1;
        } else {
            postData.q().objType = 2;
        }
        postData.q().isInPost = true;
        if (z) {
            pbCommenFloorItemViewHolder.C.setAgreeAlone(true);
            pbCommenFloorItemViewHolder.C.setData(postData.q());
        }
        if (a2Var != null && a2Var.x2()) {
            pbCommenFloorItemViewHolder.k.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.k.setData(postData.q());
    }

    public static void f(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.q qVar) {
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        Activity pageActivity = aVar.getPageContext().getPageActivity();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = l.g(pageActivity, R.dimen.M_W_X007);
        layoutParams.leftMargin = l.g(pageActivity, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        if (z) {
            pbCommenFloorItemViewHolder.m.a0(null);
            pbCommenFloorItemViewHolder.m.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().x(R.drawable.pic_video);
        a(pbCommenFloorItemViewHolder.m, view, !StringUtils.isNull(postData.t()));
        pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.m.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.m.setIsFromCDN(z2);
        pbCommenFloorItemViewHolder.m.setText(postData.J(), true, qVar);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.m.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
        pbCommenFloorItemViewHolder.m.setTag(sparseArray);
        pbCommenFloorItemViewHolder.f19531b.setTag(R.id.tag_from, sparseArray);
    }

    public static void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData != null && postData.N() != null) {
            TbRichText J = postData.J();
            d.b.i0.c2.p.b.c(postData.N(), pbCommenFloorItemViewHolder.K, false, false, J != null && StringUtils.isNull(J.toString()) && StringUtils.isNull(postData.t()));
            return;
        }
        pbCommenFloorItemViewHolder.K.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0545 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i, a aVar, a2 a2Var, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        boolean z7 = false;
        if (postData.R) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19533d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.f19533d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.f19533d.setVisibility(8);
        }
        String userId = (a2Var == null || a2Var.T() == null) ? null : a2Var.T().getUserId();
        pbCommenFloorItemViewHolder.l.setTag(null);
        pbCommenFloorItemViewHolder.l.setUserId(null);
        pbCommenFloorItemViewHolder.f19534e.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.m.setIsHost(false);
        int i2 = 16;
        if (postData.s() != null) {
            if (userId != null && !userId.equals("0") && userId.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.m.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.H;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, postData.s().getUserId());
                pbCommenFloorItemViewHolder.H.setOnClickListener(aVar.getEventController().f52996c);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.H.g(iconInfo, 2, g2, g2, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (pbCommenFloorItemViewHolder.G != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                }
                pbCommenFloorItemViewHolder.G.setOnClickListener(aVar.getEventController().f52997d);
                int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, g3, g3, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (d.w()) {
                    if (DeviceInfoUtil.isMate30()) {
                        p0.i(pbCommenFloorItemViewHolder.f19534e);
                    } else {
                        c.a(pbCommenFloorItemViewHolder.f19534e).s(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19534e, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19534e, R.color.CAM_X0106, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19534e, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            pbCommenFloorItemViewHolder.f19534e.setTag(R.id.tag_user_id, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f19534e.setTag(R.id.tag_user_name, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f19534e.setTag(R.id.tag_virtual_user_url, postData.s().getVirtualUserUrl());
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f19534e.setText(d.b.i0.c2.c.b(aVar.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.f19534e.getText().toString()));
                pbCommenFloorItemViewHolder.f19534e.setGravity(16);
                pbCommenFloorItemViewHolder.f19534e.setTag(R.id.tag_nick_name_activity, d.b.i0.c2.c.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19534e, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().a())) {
                pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds32);
                pbCommenFloorItemViewHolder.F.i(postData.s(), 4);
                pbCommenFloorItemViewHolder.l.setVisibility(8);
                pbCommenFloorItemViewHolder.F.setVisibility(0);
                pbCommenFloorItemViewHolder.F.getHeadView().W(avater, 28, false);
                pbCommenFloorItemViewHolder.F.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.F.getHeadView().setUserName(postData.s().getUserName());
                pbCommenFloorItemViewHolder.F.l(postData.s().getPendantData().a());
            } else {
                pbCommenFloorItemViewHolder.l.setGodIconWidth(R.dimen.tbds32);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.l, postData.s(), 4);
                pbCommenFloorItemViewHolder.l.setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.l.setUserName(postData.s().getUserName(), postData.S());
                pbCommenFloorItemViewHolder.l.setTag(R.id.tag_virtual_user_url, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.l.setImageDrawable(null);
                pbCommenFloorItemViewHolder.l.W(avater, 28, false);
                pbCommenFloorItemViewHolder.l.setVisibility(0);
                pbCommenFloorItemViewHolder.F.setVisibility(8);
            }
            l(pbCommenFloorItemViewHolder.f19535f, postData, userId, a2Var);
        }
        int level_id = (!aVar.isSimpleForum() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        if (a2Var != null && a2Var.x2()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.E.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.E, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.E.setVisibility(8);
        }
        if (pbCommenFloorItemViewHolder.H.getChildCount() == 1) {
            i2 = 18;
        } else if (pbCommenFloorItemViewHolder.H.getChildCount() <= 1) {
            i2 = 20;
        }
        if (pbCommenFloorItemViewHolder.f19535f.getVisibility() == 0) {
            i2 -= 2;
        }
        if (pbCommenFloorItemViewHolder.G.getChildCount() > 0) {
            i2 -= 2;
        }
        String name_show2 = postData.s() != null ? postData.s().getName_show() : "";
        int d2 = i0.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i3 = i2 - 2;
            if (d2 > i3) {
                name_show2 = i0.m(name_show2, i3) + StringHelper.STRING_MORE;
            }
        } else if (d2 > i2) {
            name_show2 = i0.m(name_show2, i2) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f19534e.setText(j(aVar, postData.s().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f19534e.setText(name_show2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.z()));
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.D());
        boolean z8 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        if (a2Var == null || aVar.getUserIdentify() == 0) {
            z3 = false;
            z4 = false;
        } else {
            z3 = (aVar.getUserIdentify() == 1002 || aVar.getUserIdentify() == 3) ? false : true;
            z4 = (aVar.getUserIdentify() == 3 || a2Var.S1()) ? false : true;
            if (postData != null && postData.s() != null) {
                String userId2 = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z3 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z3 = false;
                }
            }
        }
        if (a2Var != null && a2Var.T() != null && postData.s() != null) {
            String userId3 = a2Var.T().getUserId();
            String userId4 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId3)) {
                if (UtilHelper.isCurrentAccount(userId4)) {
                    z4 = true;
                    z5 = false;
                    z6 = true;
                    if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                        z4 = true;
                        z6 = true;
                    }
                    if (z8) {
                        z3 = false;
                        z4 = false;
                        z5 = false;
                    }
                    int i4 = postData.z() == 1 ? 0 : 1;
                    if (a2Var != null && a2Var.x2()) {
                        z3 = false;
                        z5 = false;
                    }
                    if (z3) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.getUserIdentify()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.s().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.s().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.s().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z5) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.s().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.s().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.s().getName_show());
                        }
                        sparseArray.put(R.id.tag_user_mute_thread_id, a2Var.o0());
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.D());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4 && a2Var != null) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.getUserIdentify()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(R.id.tag_del_post_id, postData.D());
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf((z2 || postData.V()) ? true : true));
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    pbCommenFloorItemViewHolder.m.setTag(sparseArray);
                    if (z) {
                        pbCommenFloorItemViewHolder.I.setTag(sparseArray);
                        return;
                    }
                    return;
                }
                z4 = true;
                z5 = true;
                z6 = false;
                if (postData != null) {
                    z4 = true;
                    z6 = true;
                }
                if (z8) {
                }
                if (postData.z() == 1) {
                }
                if (a2Var != null) {
                    z3 = false;
                    z5 = false;
                }
                if (z3) {
                }
                if (z5) {
                }
                if (!z4) {
                }
                sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                pbCommenFloorItemViewHolder.m.setTag(sparseArray);
                if (z) {
                }
            }
        }
        z5 = false;
        z6 = false;
        if (postData != null) {
        }
        if (z8) {
        }
        if (postData.z() == 1) {
        }
        if (a2Var != null) {
        }
        if (z3) {
        }
        if (z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
        pbCommenFloorItemViewHolder.m.setTag(sparseArray);
        if (z) {
        }
    }

    public static int i(int i) {
        int i2 = f52500a.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
        f52500a.put(i, dimensionPixelSize);
        return dimensionPixelSize;
    }

    public static SpannableStringBuilder j(a aVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 == null || str == null) {
            return spannableStringBuilder;
        }
        arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
        return m.h(aVar.getPageContext().getPageActivity(), str2, arrayList, true);
    }

    public static void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, e eVar, boolean z) {
        if (pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.f19530a != TbadkCoreApplication.getInst().getSkinType()) {
            if (d.w()) {
                if (DeviceInfoUtil.isMate30()) {
                    p0.i(pbCommenFloorItemViewHolder.f19534e);
                } else {
                    c.a(pbCommenFloorItemViewHolder.f19534e).s(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19534e, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19534e, R.color.CAM_X0106, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19536g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19537h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            pbCommenFloorItemViewHolder.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbCommenFloorItemViewHolder.n.b();
            if (z) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(pbCommenFloorItemViewHolder.I, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.A, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.z, R.color.CAM_X0109);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.B, R.color.CAM_X0109);
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.s, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (eVar != null) {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.q, R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0108), null), (Drawable) null);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, R.color.CAM_X0108);
                SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.p;
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
                int i = R.color.CAM_X0206;
                SkinManager.setBackgroundShapeDrawable(subPbLayout, g2, i, i);
                pbCommenFloorItemViewHolder.p.d();
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.M, R.color.CAM_X0106, 1);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.L, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.N, R.color.CAM_X0109);
                SkinManager.setImageResource(pbCommenFloorItemViewHolder.P, R.drawable.icon_arrow_more_gray);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.S, R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.Q.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.q.setVisibility(8);
                    pbCommenFloorItemViewHolder.r.setVisibility(8);
                    pbCommenFloorItemViewHolder.S.setText(R.string.close_content);
                } else if (StringUtils.isNull(eVar.k())) {
                    pbCommenFloorItemViewHolder.S.setText(eVar.k());
                } else {
                    pbCommenFloorItemViewHolder.S.setText(R.string.expand_content);
                }
            } else {
                pbCommenFloorItemViewHolder.p.setVisibility(8);
                pbCommenFloorItemViewHolder.q.setVisibility(8);
                pbCommenFloorItemViewHolder.r.setVisibility(8);
                pbCommenFloorItemViewHolder.L.setVisibility(8);
                pbCommenFloorItemViewHolder.S.setVisibility(8);
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.f19530a = TbadkCoreApplication.getInst().getSkinType();
    }

    public static void l(TextView textView, PostData postData, String str, a2 a2Var) {
        if (textView == null && postData == null) {
            return;
        }
        textView.setTag(postData);
        if (a2Var != null && a2Var.x2()) {
            textView.setVisibility(8);
            textView.setTag(null);
        } else if (postData.s() != null) {
            MetaData s = postData.s();
            if (str != null && !str.equals("0") && str.equals(s.getUserId())) {
                textView.setVisibility(0);
                textView.setAlpha(1.0f);
                textView.setText(R.string.host_name);
                textView.setBackgroundColor(0);
                c a2 = c.a(textView);
                a2.h(R.string.J_X04);
                a2.f(R.dimen.L_X01);
                a2.n(R.color.CAM_X0302);
                a2.e(R.color.CAM_X0302);
            } else if (s.getIs_bawu() == 1 && postData.W()) {
                c a3 = c.a(textView);
                a3.n(R.color.CAM_X0101);
                a3.h(R.string.J_X04);
                a3.c(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.brand_official);
            } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                c a4 = c.a(textView);
                a4.n(R.color.CAM_X0101);
                a4.h(R.string.J_X04);
                a4.c(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_member_bazhu_tip);
            } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                c a5 = c.a(textView);
                a5.n(R.color.CAM_X0101);
                a5.h(R.string.J_X04);
                a5.c(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_member_xbazhu_tip);
            } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                c a6 = c.a(textView);
                a6.n(R.color.CAM_X0101);
                a6.h(R.string.J_X04);
                a6.c(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_content_assist_tip);
            } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                c a7 = c.a(textView);
                a7.n(R.color.CAM_X0101);
                a7.h(R.string.J_X04);
                a7.c(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_manage_assist_tip);
            } else {
                textView.setVisibility(8);
            }
        } else {
            textView.setVisibility(8);
        }
    }
}
