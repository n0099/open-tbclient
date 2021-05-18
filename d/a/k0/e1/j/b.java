package d.a.k0.e1.j;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import java.util.Date;
/* loaded from: classes4.dex */
public class b extends d.a.c.a.c<UpdatesActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f54370b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f54371c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54372d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54373e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54374f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54375g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f54376h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f54377i;
    public RelativeLayout j;
    public UpdatesActivity k;
    public UpdatesItemData l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a(b bVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: d.a.k0.e1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1297b implements View.OnClickListener {
        public View$OnClickListenerC1297b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.k.isEditMode()) {
                b.this.f54376h.performClick();
            } else {
                b.this.k.onItemViewClick(b.this.f54370b, 101, 0, 0L, b.this.l);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.k.onItemViewLongClick(b.this.f54370b, 200, 0, 0L, b.this.l);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.k.onItemViewClick(b.this.f54370b, 101, 0, 0L, b.this.l);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnLongClickListener {
        public e() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.k.onItemViewLongClick(b.this.f54370b, 200, 0, 0L, b.this.l);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            view.setSelected(!view.isSelected());
            b.this.k.onCheckedChanged(view, view.isSelected(), b.this.l);
        }
    }

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.k = updatesActivity;
        k();
    }

    public void k() {
        View findViewById = this.f38636a.findViewById(R.id.root_view);
        this.f54370b = findViewById;
        this.f54371c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f54372d = (TextView) this.f54370b.findViewById(R.id.tv_group_name);
        this.f54373e = (TextView) this.f54370b.findViewById(R.id.tv_content);
        this.f54374f = (TextView) this.f54370b.findViewById(R.id.tv_title);
        this.f54375g = (TextView) this.f54370b.findViewById(R.id.tv_time);
        this.f54376h = (ImageView) this.f54370b.findViewById(R.id.cb_select);
        this.f54377i = (RelativeLayout) this.f54370b.findViewById(R.id.layout_body);
        this.j = (RelativeLayout) this.f54370b.findViewById(R.id.layout_title);
        this.f54371c.setOnClickListener(new a(this));
        this.f54377i.setClickable(true);
        this.f54377i.setLongClickable(true);
        this.j.setClickable(true);
        this.j.setLongClickable(true);
        this.f54377i.setOnClickListener(new View$OnClickListenerC1297b());
        this.f54377i.setOnLongClickListener(new c());
        this.j.setOnClickListener(new d());
        this.j.setOnLongClickListener(new e());
        this.f54376h.setOnClickListener(new f());
    }

    public void l(UpdatesItemData updatesItemData) {
        m(updatesItemData);
        refresh();
    }

    public void m(UpdatesItemData updatesItemData) {
        this.l = updatesItemData;
    }

    public void refresh() {
        if (this.l == null) {
            return;
        }
        if (this.k.isEditMode()) {
            this.f54376h.setVisibility(0);
        } else {
            this.f54376h.setVisibility(8);
            this.f54377i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f54371c.setTag(groupHeadUrl);
            this.f54371c.V(groupHeadUrl, 10, false);
        } else {
            this.f54371c.setTag(null);
        }
        this.f54371c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f54374f.setText(this.l.getTitle());
        } else {
            this.f54374f.setText(this.k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f54375g.setText(StringHelper.GetPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f54373e.setText(this.l.getContent());
        } else {
            this.f54373e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f54372d.setText(this.l.getGroupName());
        } else {
            this.f54372d.setText("");
        }
        int paddingLeft = this.f54377i.getPaddingLeft();
        int paddingTop = this.f54377i.getPaddingTop();
        int paddingRight = this.f54377i.getPaddingRight();
        int paddingBottom = this.f54377i.getPaddingBottom();
        this.k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.k.getLayoutMode().j(this.f38636a);
        this.f54376h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.k.isEditMode()) {
            SkinManager.setBackgroundResource(this.f54377i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.f54377i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.f54377i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
