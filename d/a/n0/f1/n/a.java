package d.a.n0.f1.n;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.mygroup.PersonalGroupFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public PersonalGroupFragment f58323e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f58324f = new ArrayList();

    /* renamed from: d.a.n0.f1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1376a {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f58325a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f58326b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58327c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58328d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58329e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f58330f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f58331g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f58332h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f58333i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.f58323e = personalGroupFragment;
    }

    public final void a(ImageView[] imageViewArr, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 3) {
            i2 = 3;
        }
        for (int i3 = 1; i3 <= 3; i3++) {
            if (i3 <= i2) {
                imageViewArr[i3].setVisibility(0);
            } else {
                imageViewArr[i3].setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public GroupInfoData getItem(int i2) {
        int itemId = (int) getItemId(i2);
        if (itemId < 0 || itemId >= this.f58324f.size()) {
            return null;
        }
        return this.f58324f.get(itemId);
    }

    public void c(List<GroupInfoData> list) {
        this.f58324f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f58324f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1376a c1376a;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1376a)) {
            c1376a = (C1376a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f58323e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c1376a = new C1376a();
            c1376a.f58325a = (LinearLayout) view.findViewById(R.id.click_head);
            c1376a.f58331g = (ImageView) view.findViewById(R.id.diver_top);
            c1376a.f58332h = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c1376a.f58333i = (ImageView) view.findViewById(R.id.diver_top_px);
            c1376a.f58326b = (GroupImageView) view.findViewById(R.id.item_head);
            c1376a.f58327c = (TextView) view.findViewById(R.id.item_group_name);
            c1376a.f58328d = (TextView) view.findViewById(R.id.item_group_num);
            c1376a.f58329e = (TextView) view.findViewById(R.id.item_introduce);
            c1376a.f58330f = (TextView) view.findViewById(R.id.isCreator);
            c1376a.j = (ImageView) view.findViewById(R.id.item_grade1);
            c1376a.k = (ImageView) view.findViewById(R.id.item_grade2);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
            c1376a.l = imageView;
            ImageView[] imageViewArr = new ImageView[4];
            c1376a.m = imageViewArr;
            imageViewArr[1] = c1376a.j;
            imageViewArr[2] = c1376a.k;
            imageViewArr[3] = imageView;
            view.setTag(c1376a);
        }
        GroupInfoData groupInfoData = this.f58324f.get(i2);
        c1376a.f58326b.setTag(null);
        c1376a.f58326b.setDrawBorder(true);
        c1376a.f58326b.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c1376a.f58326b.U(portrait, 10, false);
            } else {
                c1376a.f58326b.U("", 10, false);
            }
            c1376a.f58325a.setOnClickListener(this.f58323e);
            c1376a.f58325a.setTag(groupInfoData);
            c1376a.f58331g.setVisibility(8);
            c1376a.f58333i.setVisibility(8);
            c1376a.f58332h.setVisibility(0);
            c1376a.f58327c.setText(groupInfoData.getName());
            TextView textView = c1376a.f58328d;
            textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c1376a.f58329e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c1376a.f58330f.setVisibility(0);
            } else {
                c1376a.f58330f.setVisibility(8);
            }
            a(c1376a.m, groupInfoData.getGrade());
        }
        this.f58323e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f58323e.getBaseFragmentActivity().getLayoutMode().j(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            SkinManager.setViewTextColor(c1376a.f58327c, R.color.common_color_10009, 1);
            SkinManager.setImageResource(c1376a.j, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1376a.k, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1376a.l, R.drawable.icon_vip_grade_big_small_s);
        }
        return view;
    }
}
