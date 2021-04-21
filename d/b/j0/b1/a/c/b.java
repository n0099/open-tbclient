package d.b.j0.b1.a.c;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f53710a;

    /* renamed from: b  reason: collision with root package name */
    public AbsHListView f53711b;

    public b(AbsHListView absHListView) {
        this.f53711b = absHListView;
    }

    @Override // d.b.j0.b1.a.c.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.f53710a.a(actionMode, i, j, z);
        if (this.f53711b.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    public boolean b() {
        return this.f53710a != null;
    }

    public void c(a aVar) {
        this.f53710a = aVar;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f53710a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.f53710a.onCreateActionMode(actionMode, menu)) {
            this.f53711b.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f53710a.onDestroyActionMode(actionMode);
        AbsHListView absHListView = this.f53711b;
        absHListView.mChoiceActionMode = null;
        absHListView.clearChoices();
        AbsHListView absHListView2 = this.f53711b;
        absHListView2.mDataChanged = true;
        absHListView2.rememberSyncState();
        this.f53711b.requestLayout();
        this.f53711b.setLongClickable(true);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f53710a.onPrepareActionMode(actionMode, menu);
    }
}
