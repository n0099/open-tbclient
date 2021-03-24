package d.b.i0.d1.j;

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
public class b extends d.b.b.a.c<UpdatesActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f53861b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f53862c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53863d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53864e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53865f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53866g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f53867h;
    public RelativeLayout i;
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

    /* renamed from: d.b.i0.d1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1199b implements View.OnClickListener {
        public View$OnClickListenerC1199b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.k.isEditMode()) {
                b.this.f53867h.performClick();
            } else {
                b.this.k.onItemViewClick(b.this.f53861b, 101, 0, 0L, b.this.l);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.k.onItemViewLongClick(b.this.f53861b, 200, 0, 0L, b.this.l);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.k.onItemViewClick(b.this.f53861b, 101, 0, 0L, b.this.l);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnLongClickListener {
        public e() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.k.onItemViewLongClick(b.this.f53861b, 200, 0, 0L, b.this.l);
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
        View findViewById = this.f41468a.findViewById(R.id.root_view);
        this.f53861b = findViewById;
        this.f53862c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f53863d = (TextView) this.f53861b.findViewById(R.id.tv_group_name);
        this.f53864e = (TextView) this.f53861b.findViewById(R.id.tv_content);
        this.f53865f = (TextView) this.f53861b.findViewById(R.id.tv_title);
        this.f53866g = (TextView) this.f53861b.findViewById(R.id.tv_time);
        this.f53867h = (ImageView) this.f53861b.findViewById(R.id.cb_select);
        this.i = (RelativeLayout) this.f53861b.findViewById(R.id.layout_body);
        this.j = (RelativeLayout) this.f53861b.findViewById(R.id.layout_title);
        this.f53862c.setOnClickListener(new a(this));
        this.i.setClickable(true);
        this.i.setLongClickable(true);
        this.j.setClickable(true);
        this.j.setLongClickable(true);
        this.i.setOnClickListener(new View$OnClickListenerC1199b());
        this.i.setOnLongClickListener(new c());
        this.j.setOnClickListener(new d());
        this.j.setOnLongClickListener(new e());
        this.f53867h.setOnClickListener(new f());
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
            this.f53867h.setVisibility(0);
        } else {
            this.f53867h.setVisibility(8);
            this.i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f53862c.setTag(groupHeadUrl);
            this.f53862c.W(groupHeadUrl, 10, false);
        } else {
            this.f53862c.setTag(null);
        }
        this.f53862c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f53865f.setText(this.l.getTitle());
        } else {
            this.f53865f.setText(this.k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f53866g.setText(StringHelper.GetPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f53864e.setText(this.l.getContent());
        } else {
            this.f53864e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f53863d.setText(this.l.getGroupName());
        } else {
            this.f53863d.setText("");
        }
        int paddingLeft = this.i.getPaddingLeft();
        int paddingTop = this.i.getPaddingTop();
        int paddingRight = this.i.getPaddingRight();
        int paddingBottom = this.i.getPaddingBottom();
        this.k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.k.getLayoutMode().j(this.f41468a);
        this.f53867h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.k.isEditMode()) {
            SkinManager.setBackgroundResource(this.i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
