package d.b.i0.b1.a.c;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f53289a;

    /* renamed from: b  reason: collision with root package name */
    public AbsHListView f53290b;

    public b(AbsHListView absHListView) {
        this.f53290b = absHListView;
    }

    @Override // d.b.i0.b1.a.c.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.f53289a.a(actionMode, i, j, z);
        if (this.f53290b.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    public boolean b() {
        return this.f53289a != null;
    }

    public void c(a aVar) {
        this.f53289a = aVar;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f53289a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.f53289a.onCreateActionMode(actionMode, menu)) {
            this.f53290b.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f53289a.onDestroyActionMode(actionMode);
        AbsHListView absHListView = this.f53290b;
        absHListView.mChoiceActionMode = null;
        absHListView.clearChoices();
        AbsHListView absHListView2 = this.f53290b;
        absHListView2.mDataChanged = true;
        absHListView2.rememberSyncState();
        this.f53290b.requestLayout();
        this.f53290b.setLongClickable(true);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f53289a.onPrepareActionMode(actionMode, menu);
    }
}
