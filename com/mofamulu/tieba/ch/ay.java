package com.mofamulu.tieba.ch;

import android.os.AsyncTask;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends AsyncTask {
    final /* synthetic */ NickBinder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NickBinder nickBinder) {
        this.a = nickBinder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public List doInBackground(String... strArr) {
        Object obj;
        Map map;
        boolean z;
        az azVar;
        av avVar;
        Map map2;
        Map map3;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        do {
            try {
                LinkedList<String> linkedList3 = new LinkedList();
                obj = this.a.j;
                synchronized (obj) {
                    map = this.a.g;
                    linkedList3.addAll(map.keySet());
                }
                z = true;
                for (String str : linkedList3) {
                    if (!linkedList2.contains(str)) {
                        linkedList2.add(str);
                        azVar = this.a.d;
                        av a = azVar.a(str);
                        if (this.a.a(a)) {
                            this.a.b(str);
                            if (!this.a.a()) {
                                map2 = this.a.h;
                                map3 = this.a.g;
                                map2.put(str, (LinkedList) map3.get(str));
                            }
                            if (a != null && a.b != null && a.b.equalsIgnoreCase(bg.a())) {
                                NickBinder.b.a(a.b, a);
                            }
                        } else {
                            NickBinder.b.a(a.b, a);
                        }
                        if (a == null) {
                            av avVar2 = new av();
                            avVar2.b = str;
                            avVar2.g = 2;
                            avVar = avVar2;
                        } else {
                            avVar = a;
                        }
                        linkedList.add(avVar);
                        z = false;
                    }
                }
            } catch (Throwable th) {
            }
        } while (!z);
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(List list) {
        Map map;
        Object obj;
        Map map2;
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                av avVar = (av) it.next();
                map = this.a.g;
                LinkedList linkedList = (LinkedList) map.remove(avVar.b);
                if (linkedList != null) {
                    for (int i = 0; i < linkedList.size(); i++) {
                        ((ba) linkedList.get(i)).a(avVar);
                    }
                    if (!this.a.a()) {
                        map2 = this.a.h;
                        if (!map2.containsKey(avVar.b)) {
                        }
                    }
                    obj = this.a.j;
                    synchronized (obj) {
                        linkedList.clear();
                    }
                }
            }
            this.a.c = false;
        } catch (Throwable th) {
            this.a.c = false;
        }
        this.a.a(true);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        Object obj;
        Map map;
        this.a.c = false;
        obj = this.a.j;
        synchronized (obj) {
            map = this.a.g;
            map.clear();
        }
    }
}
