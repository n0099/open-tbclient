package d.a.k0.e1.n;

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
    public PersonalGroupFragment f54444e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f54445f = new ArrayList();

    /* renamed from: d.a.k0.e1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1302a {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f54446a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f54447b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54448c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f54449d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f54450e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f54451f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f54452g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f54453h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f54454i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.f54444e = personalGroupFragment;
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
        if (itemId < 0 || itemId >= this.f54445f.size()) {
            return null;
        }
        return this.f54445f.get(itemId);
    }

    public void c(List<GroupInfoData> list) {
        this.f54445f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f54445f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1302a c1302a;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1302a)) {
            c1302a = (C1302a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f54444e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c1302a = new C1302a();
            c1302a.f54446a = (LinearLayout) view.findViewById(R.id.click_head);
            c1302a.f54452g = (ImageView) view.findViewById(R.id.diver_top);
            c1302a.f54453h = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c1302a.f54454i = (ImageView) view.findViewById(R.id.diver_top_px);
            c1302a.f54447b = (GroupImageView) view.findViewById(R.id.item_head);
            c1302a.f54448c = (TextView) view.findViewById(R.id.item_group_name);
            c1302a.f54449d = (TextView) view.findViewById(R.id.item_group_num);
            c1302a.f54450e = (TextView) view.findViewById(R.id.item_introduce);
            c1302a.f54451f = (TextView) view.findViewById(R.id.isCreator);
            c1302a.j = (ImageView) view.findViewById(R.id.item_grade1);
            c1302a.k = (ImageView) view.findViewById(R.id.item_grade2);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
            c1302a.l = imageView;
            ImageView[] imageViewArr = new ImageView[4];
            c1302a.m = imageViewArr;
            imageViewArr[1] = c1302a.j;
            imageViewArr[2] = c1302a.k;
            imageViewArr[3] = imageView;
            view.setTag(c1302a);
        }
        GroupInfoData groupInfoData = this.f54445f.get(i2);
        c1302a.f54447b.setTag(null);
        c1302a.f54447b.setDrawBorder(true);
        c1302a.f54447b.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c1302a.f54447b.V(portrait, 10, false);
            } else {
                c1302a.f54447b.V("", 10, false);
            }
            c1302a.f54446a.setOnClickListener(this.f54444e);
            c1302a.f54446a.setTag(groupInfoData);
            c1302a.f54452g.setVisibility(8);
            c1302a.f54454i.setVisibility(8);
            c1302a.f54453h.setVisibility(0);
            c1302a.f54448c.setText(groupInfoData.getName());
            TextView textView = c1302a.f54449d;
            textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c1302a.f54450e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c1302a.f54451f.setVisibility(0);
            } else {
                c1302a.f54451f.setVisibility(8);
            }
            a(c1302a.m, groupInfoData.getGrade());
        }
        this.f54444e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f54444e.getBaseFragmentActivity().getLayoutMode().j(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            SkinManager.setViewTextColor(c1302a.f54448c, R.color.common_color_10009, 1);
            SkinManager.setImageResource(c1302a.j, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1302a.k, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1302a.l, R.drawable.icon_vip_grade_big_small_s);
        }
        return view;
    }
}
