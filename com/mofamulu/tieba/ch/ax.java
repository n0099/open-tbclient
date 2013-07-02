package com.mofamulu.tieba.ch;

import android.os.AsyncTask;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends AsyncTask {
    final /* synthetic */ NickBinder a;
    private final List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NickBinder nickBinder, List list) {
        this.a = nickBinder;
        this.b = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public LinkedList doInBackground(Integer... numArr) {
        return this.a.a(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(LinkedList linkedList) {
        Map map;
        Object obj;
        if (linkedList == null) {
            this.a.a(true);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            av avVar = (av) it.next();
            map = this.a.h;
            LinkedList linkedList2 = (LinkedList) map.remove(avVar.b);
            if (linkedList2 != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= linkedList2.size()) {
                        break;
                    }
                    ((ba) linkedList2.get(i2)).a(avVar);
                    i = i2 + 1;
                }
                obj = this.a.j;
                synchronized (obj) {
                    linkedList2.clear();
                }
            }
        }
        this.a.a(true);
    }
}
