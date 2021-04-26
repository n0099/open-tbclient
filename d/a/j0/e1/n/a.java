package d.a.j0.e1.n;

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
    public PersonalGroupFragment f53737e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f53738f = new ArrayList();

    /* renamed from: d.a.j0.e1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1230a {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f53739a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f53740b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f53741c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f53742d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f53743e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f53744f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f53745g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f53746h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f53747i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.f53737e = personalGroupFragment;
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
        if (itemId < 0 || itemId >= this.f53738f.size()) {
            return null;
        }
        return this.f53738f.get(itemId);
    }

    public void c(List<GroupInfoData> list) {
        this.f53738f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f53738f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1230a c1230a;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1230a)) {
            c1230a = (C1230a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f53737e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c1230a = new C1230a();
            c1230a.f53739a = (LinearLayout) view.findViewById(R.id.click_head);
            c1230a.f53745g = (ImageView) view.findViewById(R.id.diver_top);
            c1230a.f53746h = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c1230a.f53747i = (ImageView) view.findViewById(R.id.diver_top_px);
            c1230a.f53740b = (GroupImageView) view.findViewById(R.id.item_head);
            c1230a.f53741c = (TextView) view.findViewById(R.id.item_group_name);
            c1230a.f53742d = (TextView) view.findViewById(R.id.item_group_num);
            c1230a.f53743e = (TextView) view.findViewById(R.id.item_introduce);
            c1230a.f53744f = (TextView) view.findViewById(R.id.isCreator);
            c1230a.j = (ImageView) view.findViewById(R.id.item_grade1);
            c1230a.k = (ImageView) view.findViewById(R.id.item_grade2);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
            c1230a.l = imageView;
            ImageView[] imageViewArr = new ImageView[4];
            c1230a.m = imageViewArr;
            imageViewArr[1] = c1230a.j;
            imageViewArr[2] = c1230a.k;
            imageViewArr[3] = imageView;
            view.setTag(c1230a);
        }
        GroupInfoData groupInfoData = this.f53738f.get(i2);
        c1230a.f53740b.setTag(null);
        c1230a.f53740b.setDrawBorder(true);
        c1230a.f53740b.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c1230a.f53740b.V(portrait, 10, false);
            } else {
                c1230a.f53740b.V("", 10, false);
            }
            c1230a.f53739a.setOnClickListener(this.f53737e);
            c1230a.f53739a.setTag(groupInfoData);
            c1230a.f53745g.setVisibility(8);
            c1230a.f53747i.setVisibility(8);
            c1230a.f53746h.setVisibility(0);
            c1230a.f53741c.setText(groupInfoData.getName());
            TextView textView = c1230a.f53742d;
            textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c1230a.f53743e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c1230a.f53744f.setVisibility(0);
            } else {
                c1230a.f53744f.setVisibility(8);
            }
            a(c1230a.m, groupInfoData.getGrade());
        }
        this.f53737e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f53737e.getBaseFragmentActivity().getLayoutMode().j(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            SkinManager.setViewTextColor(c1230a.f53741c, R.color.common_color_10009, 1);
            SkinManager.setImageResource(c1230a.j, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1230a.k, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1230a.l, R.drawable.icon_vip_grade_big_small_s);
        }
        return view;
    }
}
