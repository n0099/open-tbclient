package com.mofamulu.tieba.map;

import android.content.Context;
import android.widget.Toast;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.model.av;
import com.baidu.tieba.model.aw;
import com.baidu.zeus.WebChromeClient;
import com.mofamulu.tieba.ch.NickBinder;
import com.mofamulu.tieba.ch.az;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask {
    com.baidu.tieba.util.r a;
    double b;
    double c;
    final /* synthetic */ FreeJumpByMapActivity d;

    public g(FreeJumpByMapActivity freeJumpByMapActivity, double d, double d2) {
        this.d = freeJumpByMapActivity;
        this.b = d;
        this.c = d2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public av a(String... strArr) {
        av avVar;
        String name;
        com.baidu.tieba.util.a aVar;
        com.baidu.tieba.util.a aVar2;
        try {
            this.a = new com.baidu.tieba.util.r(strArr[0]);
            this.a.a("lng", String.valueOf(this.c));
            this.a.a("lat", String.valueOf(this.b));
            this.a.a("width", String.valueOf(com.baidu.tieba.util.aa.a((Context) this.d)));
            this.a.a("height", String.valueOf(com.baidu.tieba.util.aa.b((Context) this.d)));
            this.a.a("guide", "0");
            this.a.a("ispv", "1");
            this.a.a("pn", "1");
            String j = this.a.j();
            if (this.a.c()) {
                avVar = new av();
                avVar.a(j);
            } else {
                avVar = null;
            }
            if (avVar == null) {
                return null;
            }
            az azVar = new az(this.d);
            Iterator it = avVar.a().iterator();
            while (it.hasNext()) {
                aw awVar = (aw) it.next();
                if (awVar.l() != null && (name = awVar.l().getName()) != null) {
                    com.mofamulu.tieba.ch.av avVar2 = (com.mofamulu.tieba.ch.av) NickBinder.b.a(name);
                    if (avVar2 == null && (avVar2 = azVar.a(name)) != null) {
                        NickBinder.b.a(name, avVar2);
                    }
                    if (avVar2 != null) {
                        if (avVar2.c() == 15856113) {
                            awVar.a(100);
                        }
                        if (avVar2.c() != 0) {
                            aVar = this.d.h;
                            if (aVar.b(awVar.l().getPortrait()) == null) {
                                awVar.a(WebChromeClient.STRING_DLG_TITLE_DATETIME);
                                aVar2 = this.d.h;
                                aVar2.b(awVar.l().getPortrait(), new h(this, awVar));
                            }
                        }
                    }
                }
            }
            azVar.b();
            return avVar;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(av avVar) {
        String string;
        this.d.i = null;
        if (this.a != null) {
            if (avVar == null) {
                if (this.a.g() != null) {
                    string = this.a.g();
                } else {
                    string = this.d.getString(R.string.neterror);
                }
                Toast.makeText(this.d, string, 0);
                return;
            }
            this.d.a(avVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.a != null) {
            this.a.h();
        }
        this.d.i = null;
        super.cancel(true);
    }
}
