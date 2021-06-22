package d.a.o0.f1.j;

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
    public View f58374b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f58375c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58376d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58377e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58378f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58379g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58380h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f58381i;
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

    /* renamed from: d.a.o0.f1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1375b implements View.OnClickListener {
        public View$OnClickListenerC1375b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.k.isEditMode()) {
                b.this.f58380h.performClick();
            } else {
                b.this.k.onItemViewClick(b.this.f58374b, 101, 0, 0L, b.this.l);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.k.onItemViewLongClick(b.this.f58374b, 200, 0, 0L, b.this.l);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.k.onItemViewClick(b.this.f58374b, 101, 0, 0L, b.this.l);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnLongClickListener {
        public e() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.k.onItemViewLongClick(b.this.f58374b, 200, 0, 0L, b.this.l);
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
        View findViewById = this.f42056a.findViewById(R.id.root_view);
        this.f58374b = findViewById;
        this.f58375c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f58376d = (TextView) this.f58374b.findViewById(R.id.tv_group_name);
        this.f58377e = (TextView) this.f58374b.findViewById(R.id.tv_content);
        this.f58378f = (TextView) this.f58374b.findViewById(R.id.tv_title);
        this.f58379g = (TextView) this.f58374b.findViewById(R.id.tv_time);
        this.f58380h = (ImageView) this.f58374b.findViewById(R.id.cb_select);
        this.f58381i = (RelativeLayout) this.f58374b.findViewById(R.id.layout_body);
        this.j = (RelativeLayout) this.f58374b.findViewById(R.id.layout_title);
        this.f58375c.setOnClickListener(new a(this));
        this.f58381i.setClickable(true);
        this.f58381i.setLongClickable(true);
        this.j.setClickable(true);
        this.j.setLongClickable(true);
        this.f58381i.setOnClickListener(new View$OnClickListenerC1375b());
        this.f58381i.setOnLongClickListener(new c());
        this.j.setOnClickListener(new d());
        this.j.setOnLongClickListener(new e());
        this.f58380h.setOnClickListener(new f());
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
            this.f58380h.setVisibility(0);
        } else {
            this.f58380h.setVisibility(8);
            this.f58381i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f58375c.setTag(groupHeadUrl);
            this.f58375c.U(groupHeadUrl, 10, false);
        } else {
            this.f58375c.setTag(null);
        }
        this.f58375c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f58378f.setText(this.l.getTitle());
        } else {
            this.f58378f.setText(this.k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f58379g.setText(StringHelper.GetPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f58377e.setText(this.l.getContent());
        } else {
            this.f58377e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f58376d.setText(this.l.getGroupName());
        } else {
            this.f58376d.setText("");
        }
        int paddingLeft = this.f58381i.getPaddingLeft();
        int paddingTop = this.f58381i.getPaddingTop();
        int paddingRight = this.f58381i.getPaddingRight();
        int paddingBottom = this.f58381i.getPaddingBottom();
        this.k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.k.getLayoutMode().j(this.f42056a);
        this.f58380h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.k.isEditMode()) {
            SkinManager.setBackgroundResource(this.f58381i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.f58381i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.f58381i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
