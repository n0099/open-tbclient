package com.mofamulu.tieba.map;

import android.location.Address;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.model.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask {
    com.baidu.tieba.util.r a;
    Address b;
    boolean c;
    final /* synthetic */ FreeNearbyForumActivity d;

    public v(FreeNearbyForumActivity freeNearbyForumActivity, Address address, boolean z) {
        this.d = freeNearbyForumActivity;
        this.b = address;
        this.c = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public at a(String... strArr) {
        try {
            this.a = new com.baidu.tieba.util.r(strArr[0]);
            this.a.a("lng", String.valueOf(this.b.getLongitude()));
            this.a.a("lat", String.valueOf(this.b.getLatitude()));
            if (this.c) {
                this.a.a("ispv", "1");
            } else {
                this.a.a("ispv", "0");
            }
            String j = this.a.j();
            if (this.a.c()) {
                at atVar = new at();
                atVar.b(j);
                return atVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "", "NearbyForumListModel.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(at atVar) {
        ProgressBar progressBar;
        at atVar2;
        com.baidu.tieba.nearby.d dVar;
        ListView listView;
        this.d.g = null;
        this.d.j = false;
        progressBar = this.d.k;
        progressBar.setVisibility(8);
        if (this.a != null) {
            if (atVar != null) {
                atVar2 = this.d.b;
                atVar2.a(atVar.a());
                dVar = this.d.d;
                dVar.notifyDataSetChanged();
                listView = this.d.c;
                listView.setSelection(0);
            } else if (this.a.g() != null) {
                this.d.a(this.a.g());
            } else {
                this.d.a(this.d.getString(R.string.neterror));
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.a != null) {
            this.a.h();
        }
        this.d.g = null;
        this.d.j = false;
        progressBar = this.d.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
