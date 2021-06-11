package d.a.n0.f1.j;

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
    public View f58249b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f58250c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58251d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58252e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58253f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58254g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58255h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f58256i;
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

    /* renamed from: d.a.n0.f1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1371b implements View.OnClickListener {
        public View$OnClickListenerC1371b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.k.isEditMode()) {
                b.this.f58255h.performClick();
            } else {
                b.this.k.onItemViewClick(b.this.f58249b, 101, 0, 0L, b.this.l);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.k.onItemViewLongClick(b.this.f58249b, 200, 0, 0L, b.this.l);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.k.onItemViewClick(b.this.f58249b, 101, 0, 0L, b.this.l);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnLongClickListener {
        public e() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.k.onItemViewLongClick(b.this.f58249b, 200, 0, 0L, b.this.l);
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
        View findViewById = this.f41953a.findViewById(R.id.root_view);
        this.f58249b = findViewById;
        this.f58250c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f58251d = (TextView) this.f58249b.findViewById(R.id.tv_group_name);
        this.f58252e = (TextView) this.f58249b.findViewById(R.id.tv_content);
        this.f58253f = (TextView) this.f58249b.findViewById(R.id.tv_title);
        this.f58254g = (TextView) this.f58249b.findViewById(R.id.tv_time);
        this.f58255h = (ImageView) this.f58249b.findViewById(R.id.cb_select);
        this.f58256i = (RelativeLayout) this.f58249b.findViewById(R.id.layout_body);
        this.j = (RelativeLayout) this.f58249b.findViewById(R.id.layout_title);
        this.f58250c.setOnClickListener(new a(this));
        this.f58256i.setClickable(true);
        this.f58256i.setLongClickable(true);
        this.j.setClickable(true);
        this.j.setLongClickable(true);
        this.f58256i.setOnClickListener(new View$OnClickListenerC1371b());
        this.f58256i.setOnLongClickListener(new c());
        this.j.setOnClickListener(new d());
        this.j.setOnLongClickListener(new e());
        this.f58255h.setOnClickListener(new f());
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
            this.f58255h.setVisibility(0);
        } else {
            this.f58255h.setVisibility(8);
            this.f58256i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f58250c.setTag(groupHeadUrl);
            this.f58250c.U(groupHeadUrl, 10, false);
        } else {
            this.f58250c.setTag(null);
        }
        this.f58250c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f58253f.setText(this.l.getTitle());
        } else {
            this.f58253f.setText(this.k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f58254g.setText(StringHelper.GetPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f58252e.setText(this.l.getContent());
        } else {
            this.f58252e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f58251d.setText(this.l.getGroupName());
        } else {
            this.f58251d.setText("");
        }
        int paddingLeft = this.f58256i.getPaddingLeft();
        int paddingTop = this.f58256i.getPaddingTop();
        int paddingRight = this.f58256i.getPaddingRight();
        int paddingBottom = this.f58256i.getPaddingBottom();
        this.k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.k.getLayoutMode().j(this.f41953a);
        this.f58255h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.k.isEditMode()) {
            SkinManager.setBackgroundResource(this.f58256i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.f58256i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.f58256i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
