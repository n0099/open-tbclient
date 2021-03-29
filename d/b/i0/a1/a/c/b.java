package d.b.i0.a1.a.c;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f51869a;

    /* renamed from: b  reason: collision with root package name */
    public AbsHListView f51870b;

    public b(AbsHListView absHListView) {
        this.f51870b = absHListView;
    }

    @Override // d.b.i0.a1.a.c.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.f51869a.a(actionMode, i, j, z);
        if (this.f51870b.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    public boolean b() {
        return this.f51869a != null;
    }

    public void c(a aVar) {
        this.f51869a = aVar;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f51869a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.f51869a.onCreateActionMode(actionMode, menu)) {
            this.f51870b.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f51869a.onDestroyActionMode(actionMode);
        AbsHListView absHListView = this.f51870b;
        absHListView.mChoiceActionMode = null;
        absHListView.clearChoices();
        AbsHListView absHListView2 = this.f51870b;
        absHListView2.mDataChanged = true;
        absHListView2.rememberSyncState();
        this.f51870b.requestLayout();
        this.f51870b.setLongClickable(true);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f51869a.onPrepareActionMode(actionMode, menu);
    }
}
