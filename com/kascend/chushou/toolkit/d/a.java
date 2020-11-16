package com.kascend.chushou.toolkit.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.kascend.chushou.bean.UpdateVo;
import com.kascend.chushou.bean.UpdateVoAll;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.d.c;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.d;
import com.opensource.svgaplayer.f;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tv.chushou.zues.utils.d;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4219a = c.pjq.a();
    private static final String b = c.pjq.b();
    private static volatile a pyU;
    private final List<UpdateVo> d = new ArrayList();
    private final Set<String> pyV = new HashSet();
    private volatile boolean f = false;
    private volatile boolean g = false;

    public static a ewg() {
        if (pyU == null) {
            synchronized (a.class) {
                if (pyU == null) {
                    pyU = new a();
                }
            }
        }
        return pyU;
    }

    private a() {
        File file = new File(f4219a);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
    }

    public void b() {
        if (!this.f) {
            c();
        }
    }

    private void c() {
        if (tv.chushou.zues.utils.a.eHN() && !this.g) {
            this.g = true;
            com.kascend.chushou.c.c.etT().a(new tv.chushou.basis.d.a.c.a<String>() { // from class: com.kascend.chushou.toolkit.d.a.1
                @Override // tv.chushou.basis.d.a.c.a
                public void onStart() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.basis.d.a.c.a
                /* renamed from: a */
                public void onSuccess(String str) {
                    a.this.g = false;
                    a.this.f = true;
                    e.d("AnimPluginManager", "api success");
                    UpdateVoAll updateVoAll = (UpdateVoAll) d.c(str, (Class<Object>) UpdateVoAll.class);
                    if (updateVoAll != null && !h.isEmpty(updateVoAll.updateApk)) {
                        List a2 = a.this.a(updateVoAll.updateApk);
                        if (!h.isEmpty(a2)) {
                            synchronized (a.this.d) {
                                a.this.d.clear();
                                a.this.d.addAll(a2);
                            }
                        }
                    }
                }

                @Override // tv.chushou.basis.d.a.c.a
                public void onFailure(int i, @Nullable String str, @Nullable Throwable th) {
                    a.this.g = false;
                    e.e("AnimPluginManager", "", th);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<UpdateVo> a(List<UpdateVo> list) {
        boolean z;
        int a2;
        if (list == null) {
            e.d("AnimPluginManager", "getpluginin from servre error!");
            return null;
        } else if (list.size() == 0) {
            e.d("AnimPluginManager", "no data from server, need remove local plugin file");
            tv.chushou.a.a.d.a.delete(new File(f4219a));
            tv.chushou.a.a.d.a.ax(new File(f4219a));
            return null;
        } else {
            File file = new File(f4219a);
            if (!file.exists()) {
                file.mkdirs();
                return list;
            }
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = size - 1; i >= 0; i--) {
                UpdateVo updateVo = list.get(i);
                arrayList.add(updateVo);
                int length2 = listFiles.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length2) {
                        File file2 = listFiles[i2];
                        String name = file2.getName();
                        if (name.contains("apk")) {
                            if (name.equals(updateVo.apk_name) && h.parseInt(updateVo.apk_versionCode) <= (a2 = a(tv.chushou.basis.d.b.eHp(), file2.getAbsolutePath()))) {
                                e.d("AnimPluginManager", updateVo.apk_name + " no need to update, version=" + a2);
                                list.remove(i);
                                break;
                            }
                            i2++;
                        } else {
                            if (name.contains("svga") && name.equals(updateVo.apk_name)) {
                                String d = d(name);
                                if (!h.isEmpty(d) && h.parseInt(updateVo.apk_versionCode) <= h.parseInt(d)) {
                                    e.d("AnimPluginManager", updateVo.apk_name + " no need to update, code=" + d);
                                    list.remove(i);
                                    break;
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
            for (int i3 = length - 1; i3 >= 0; i3--) {
                File file3 = listFiles[i3];
                String name2 = file3.getName();
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((UpdateVo) it.next()).apk_name.equals(name2)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    e.d("AnimPluginManager", name2 + " should be deleted!");
                    file3.delete();
                    if (name2.contains("svga")) {
                        e(name2);
                    }
                }
            }
            return list;
        }
    }

    private boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) tv.chushou.basis.d.b.eHp().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        return networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [315=5, 316=4, 317=6, 318=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kascend.chushou.bean.UpdateVo r11) {
        /*
            r10 = this;
            r2 = 0
            r8 = 1
            r7 = 0
            if (r11 != 0) goto L6
        L5:
            return
        L6:
            java.lang.String r0 = r11.uri
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1b
            java.util.List<com.kascend.chushou.bean.UpdateVo> r1 = r10.d
            monitor-enter(r1)
            java.util.List<com.kascend.chushou.bean.UpdateVo> r0 = r10.d     // Catch: java.lang.Throwable -> L18
            r0.remove(r11)     // Catch: java.lang.Throwable -> L18
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            goto L5
        L18:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            throw r0
        L1b:
            boolean r0 = r10.d()
            if (r0 != 0) goto L45
            java.lang.String r0 = "AnimPluginManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Download "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r11.apk_name
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ",but not wifi, return"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            tv.chushou.zues.utils.e.d(r0, r1)
            goto L5
        L45:
            java.util.Set<java.lang.String> r1 = r10.pyV
            monitor-enter(r1)
            java.util.Set<java.lang.String> r0 = r10.pyV     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = r11.uri     // Catch: java.lang.Throwable -> L77
            boolean r0 = r0.contains(r3)     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L7a
            java.lang.String r0 = "AnimPluginManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r2.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = "Download "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = r11.apk_name     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = ", already downloading"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L77
            tv.chushou.zues.utils.e.d(r0, r2)     // Catch: java.lang.Throwable -> L77
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L77
            goto L5
        L77:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L77
            throw r0
        L7a:
            java.util.Set<java.lang.String> r0 = r10.pyV     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = r11.uri     // Catch: java.lang.Throwable -> L77
            r0.add(r3)     // Catch: java.lang.Throwable -> L77
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r11.apk_name
            java.lang.String r0 = r10.a(r0)
            java.io.File r3 = new java.io.File
            r3.<init>(r0)
            boolean r0 = r3.exists()
            if (r0 == 0) goto L96
            r3.delete()
        L96:
            tv.chushou.basis.d.b r0 = tv.chushou.basis.d.b.eHr()
            java.lang.Class<tv.chushou.basis.http.Http> r1 = tv.chushou.basis.http.Http.class
            tv.chushou.basis.d.a r0 = r0.S(r1)
            tv.chushou.basis.http.Http r0 = (tv.chushou.basis.http.Http) r0
            if (r0 != 0) goto Lb4
            java.util.Set<java.lang.String> r1 = r10.pyV
            monitor-enter(r1)
            java.util.Set<java.lang.String> r0 = r10.pyV     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r2 = r11.uri     // Catch: java.lang.Throwable -> Lb1
            r0.remove(r2)     // Catch: java.lang.Throwable -> Lb1
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb1
            goto L5
        Lb1:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb1
            throw r0
        Lb4:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L279
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L279
            java.lang.String r2 = r11.uri     // Catch: java.lang.Throwable -> L232
            boolean r0 = r0.downloadSync(r2, r1)     // Catch: java.lang.Throwable -> L232
            if (r0 != 0) goto Ldb
            tv.chushou.a.a.d.a.delete(r3)     // Catch: java.lang.Throwable -> L232
            java.util.Set<java.lang.String> r2 = r10.pyV
            monitor-enter(r2)
            java.util.Set<java.lang.String> r0 = r10.pyV     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r3 = r11.uri     // Catch: java.lang.Throwable -> Ld8
            r0.remove(r3)     // Catch: java.lang.Throwable -> Ld8
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Ld8
            java.io.Closeable[] r0 = new java.io.Closeable[r8]
            r0[r7] = r1
            tv.chushou.a.a.d.a.b(r0)
            goto L5
        Ld8:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Ld8
            throw r0
        Ldb:
            java.lang.String r0 = "AnimPluginManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L232
            r2.<init>()     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = "download "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = r11.apk_name     // Catch: java.lang.Throwable -> L232
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = " success"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L232
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L232
            tv.chushou.zues.utils.e.d(r0, r2)     // Catch: java.lang.Throwable -> L232
            java.lang.String r0 = r11.apk_name     // Catch: java.lang.Throwable -> L232
            java.lang.String r0 = r10.b(r0)     // Catch: java.lang.Throwable -> L232
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L232
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L232
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L232
            if (r0 == 0) goto L112
            r2.delete()     // Catch: java.lang.Throwable -> L232
        L112:
            r3.renameTo(r2)     // Catch: java.lang.Throwable -> L232
            java.lang.String r0 = "AnimPluginManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L232
            r2.<init>()     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = "rename "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = r11.apk_name     // Catch: java.lang.Throwable -> L232
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = " success"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L232
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L232
            tv.chushou.zues.utils.e.d(r0, r2)     // Catch: java.lang.Throwable -> L232
            java.lang.String r0 = r11.apk_name     // Catch: java.lang.Throwable -> L232
            java.lang.String r2 = "apk"
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Throwable -> L232
            if (r0 == 0) goto L1fb
            android.app.Application r0 = tv.chushou.basis.d.b.eHp()     // Catch: java.lang.Throwable -> L232
            tv.chushou.basis.a.c r0 = tv.chushou.basis.a.c.hy(r0)     // Catch: java.lang.Throwable -> L232
            java.lang.String r0 = r0.eHd()     // Catch: java.lang.Throwable -> L232
            if (r0 == 0) goto L182
            java.lang.String r2 = r11.apk_name     // Catch: java.lang.Throwable -> L232
            r4 = 0
            java.lang.String r5 = r11.apk_name     // Catch: java.lang.Throwable -> L232
            java.lang.String r6 = "."
            int r5 = r5.lastIndexOf(r6)     // Catch: java.lang.Throwable -> L232
            java.lang.String r2 = r2.substring(r4, r5)     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = "/"
            boolean r4 = r0.endsWith(r4)     // Catch: java.lang.Throwable -> L232
            if (r4 == 0) goto L1db
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L232
            r4.<init>()     // Catch: java.lang.Throwable -> L232
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch: java.lang.Throwable -> L232
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L232
            java.lang.String r2 = ".dex"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L232
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L232
        L182:
            if (r0 == 0) goto L19b
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L232
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L232
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L232
            if (r0 == 0) goto L19b
            java.lang.String r0 = "AnimPluginManager"
            java.lang.String r4 = "update successful, delete the old dex file"
            tv.chushou.zues.utils.e.d(r0, r4)     // Catch: java.lang.Throwable -> L232
            r2.delete()     // Catch: java.lang.Throwable -> L232
        L19b:
            java.util.List<com.kascend.chushou.bean.UpdateVo> r2 = r10.d     // Catch: java.lang.Throwable -> L232
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L232
            java.util.List<com.kascend.chushou.bean.UpdateVo> r0 = r10.d     // Catch: java.lang.Throwable -> L251
            r0.remove(r11)     // Catch: java.lang.Throwable -> L251
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L251
            java.lang.String r0 = "AnimPluginManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L232
            r2.<init>()     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = "remove "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = r11.apk_name     // Catch: java.lang.Throwable -> L232
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = " from downloadNodes"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L232
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L232
            tv.chushou.zues.utils.e.d(r0, r2)     // Catch: java.lang.Throwable -> L232
            java.util.Set<java.lang.String> r2 = r10.pyV
            monitor-enter(r2)
            java.util.Set<java.lang.String> r0 = r10.pyV     // Catch: java.lang.Throwable -> L268
            java.lang.String r3 = r11.uri     // Catch: java.lang.Throwable -> L268
            r0.remove(r3)     // Catch: java.lang.Throwable -> L268
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L268
            java.io.Closeable[] r0 = new java.io.Closeable[r8]
            r0[r7] = r1
            tv.chushou.a.a.d.a.b(r0)
            goto L5
        L1db:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L232
            r4.<init>()     // Catch: java.lang.Throwable -> L232
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch: java.lang.Throwable -> L232
            java.lang.String r4 = "/"
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch: java.lang.Throwable -> L232
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L232
            java.lang.String r2 = ".dex"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L232
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L232
            goto L182
        L1fb:
            java.lang.String r0 = r11.apk_name     // Catch: java.lang.Throwable -> L232
            java.lang.String r2 = "svga"
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Throwable -> L232
            if (r0 == 0) goto L19b
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L232
            java.lang.String r2 = com.kascend.chushou.toolkit.d.a.b     // Catch: java.lang.Throwable -> L232
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L232
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L232
            if (r2 != 0) goto L216
            r0.mkdirs()     // Catch: java.lang.Throwable -> L232
        L216:
            java.lang.String r0 = r11.apk_name     // Catch: java.lang.Throwable -> L232
            java.lang.String r0 = r10.c(r0)     // Catch: java.lang.Throwable -> L232
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L232
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L232
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L232
            if (r0 == 0) goto L22a
            r2.delete()     // Catch: java.lang.Throwable -> L232
        L22a:
            java.lang.String r0 = r11.apk_versionCode     // Catch: java.lang.Throwable -> L232
            r4 = 0
            tv.chushou.a.a.d.a.b(r0, r4, r2)     // Catch: java.lang.Throwable -> L232
            goto L19b
        L232:
            r0 = move-exception
            r0 = r1
        L234:
            boolean r1 = r3.exists()     // Catch: java.lang.Throwable -> L274
            if (r1 == 0) goto L23d
            r3.delete()     // Catch: java.lang.Throwable -> L274
        L23d:
            java.util.Set<java.lang.String> r1 = r10.pyV
            monitor-enter(r1)
            java.util.Set<java.lang.String> r2 = r10.pyV     // Catch: java.lang.Throwable -> L26b
            java.lang.String r3 = r11.uri     // Catch: java.lang.Throwable -> L26b
            r2.remove(r3)     // Catch: java.lang.Throwable -> L26b
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L26b
            java.io.Closeable[] r1 = new java.io.Closeable[r8]
            r1[r7] = r0
            tv.chushou.a.a.d.a.b(r1)
            goto L5
        L251:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L251
            throw r0     // Catch: java.lang.Throwable -> L232
        L254:
            r0 = move-exception
        L255:
            java.util.Set<java.lang.String> r2 = r10.pyV
            monitor-enter(r2)
            java.util.Set<java.lang.String> r3 = r10.pyV     // Catch: java.lang.Throwable -> L26e
            java.lang.String r4 = r11.uri     // Catch: java.lang.Throwable -> L26e
            r3.remove(r4)     // Catch: java.lang.Throwable -> L26e
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L26e
            java.io.Closeable[] r2 = new java.io.Closeable[r8]
            r2[r7] = r1
            tv.chushou.a.a.d.a.b(r2)
            throw r0
        L268:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L268
            throw r0
        L26b:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L26b
            throw r0
        L26e:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L26e
            throw r0
        L271:
            r0 = move-exception
            r1 = r2
            goto L255
        L274:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L255
        L279:
            r0 = move-exception
            r0 = r2
            goto L234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kascend.chushou.toolkit.d.a.a(com.kascend.chushou.bean.UpdateVo):void");
    }

    private String a(String str) {
        return f4219a + str + "tmp";
    }

    private String b(String str) {
        return f4219a + str;
    }

    private String c(String str) {
        return b + str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [388=5] */
    public View a(Context context, String str, View view, Animation.AnimationListener animationListener, Object obj) {
        View view2;
        e.d("AnimPluginManager", "startAnimation()<----");
        String str2 = "animplug" + str + ".apk";
        String str3 = f4219a + str2;
        File file = new File(str3);
        if (!file.exists() || file.isDirectory()) {
            e.e("AnimPluginManager", str3 + " not exist!");
            f(str2);
            return null;
        }
        tv.chushou.basis.a.c hy = tv.chushou.basis.a.c.hy(context);
        hy.bu(str3, false);
        String str4 = "com.kascend.chushouplugin.animplug" + str;
        tv.chushou.basis.a.d ZZ = hy.ZZ(str4);
        if (ZZ != null) {
            try {
                Class loadClass = ZZ.qmD.loadClass(str4 + ".PluginInterface");
                view2 = (View) loadClass.getMethod("startAnimation", Context.class, View.class, Resources.class, Animation.AnimationListener.class, Object.class).invoke(loadClass.newInstance(), context, view, ZZ.resources, animationListener, obj);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                view2 = null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                view2 = null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                view2 = null;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                view2 = null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                view2 = null;
            } catch (Throwable th) {
                view2 = null;
            }
            e.d("AnimPluginManager", "startAnimation()---->ret=" + view2);
            return view2;
        }
        return null;
    }

    public boolean a(Context context, String str, View view, View view2) {
        e.d("AnimPluginManager", "stopAnimation()<----");
        String str2 = f4219a + "animplug" + str + ".apk";
        File file = new File(str2);
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        tv.chushou.basis.a.c hy = tv.chushou.basis.a.c.hy(context);
        hy.bu(str2, false);
        String str3 = "com.kascend.chushouplugin.animplug" + str;
        tv.chushou.basis.a.d ZZ = hy.ZZ(str3);
        Class<?>[] clsArr = {Context.class, View.class, Resources.class, View.class};
        try {
            Class loadClass = ZZ.qmD.loadClass(str3 + ".PluginInterface");
            loadClass.getMethod("stopAnimation", clsArr).invoke(loadClass.newInstance(), context, view, ZZ.resources, view2);
            e.d("AnimPluginManager", "stopAnimation()---->");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return false;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return false;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return false;
        }
    }

    private static int a(Context context, String str) {
        PackageInfo packageArchiveInfo;
        if (context == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return 0;
        }
        return packageArchiveInfo.versionCode;
    }

    private String d(String str) {
        File file = new File(b);
        if (!file.exists()) {
            file.mkdirs();
            return "";
        }
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            if (file2.getName().equals(str)) {
                return tv.chushou.a.a.d.a.k(file2, null);
            }
        }
        return "";
    }

    private void e(String str) {
        File file = new File(c(str));
        if (file.exists()) {
            file.delete();
        }
    }

    public void a(Context context, String str, final b bVar, final SVGAImageView sVGAImageView, final ChatInfo chatInfo) {
        if (context != null) {
            String str2 = "svga" + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + chatInfo.mAnimationType + ".svga";
            String str3 = f4219a + "svga" + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + chatInfo.mAnimationType + ".svga";
            File file = new File(str3);
            if (!file.exists() || file.isDirectory()) {
                e.e("AnimPluginManager", str3 + " not exist!");
                f(str2);
                bVar.a();
                return;
            }
            try {
                new com.opensource.svgaplayer.d(context).a(new FileInputStream(file), str, new d.c() { // from class: com.kascend.chushou.toolkit.d.a.2
                    @Override // com.opensource.svgaplayer.d.c
                    public void a(f fVar) {
                        com.opensource.svgaplayer.c cVar = new com.opensource.svgaplayer.c();
                        TextPaint textPaint = new TextPaint();
                        textPaint.setTextSize(25.0f);
                        textPaint.setColor(Color.parseColor("#ffff00"));
                        TextPaint textPaint2 = new TextPaint();
                        textPaint2.setTextSize(23.0f);
                        textPaint2.setColor(Color.parseColor("#ffffff"));
                        cVar.a(chatInfo.mUserNickname, textPaint, "username");
                        cVar.a(chatInfo.mContent, textPaint2, "content");
                        sVGAImageView.setVideoItem(fVar, cVar);
                        sVGAImageView.startAnimation();
                        sVGAImageView.setVisibility(0);
                        sVGAImageView.setCallback(bVar);
                    }

                    @Override // com.opensource.svgaplayer.d.c
                    public void onError() {
                        bVar.a();
                    }
                }, true);
            } catch (Throwable th) {
                bVar.a();
            }
        }
    }

    private void f(String str) {
        final UpdateVo updateVo;
        if (!this.f) {
            c();
            return;
        }
        synchronized (this.d) {
            Iterator<UpdateVo> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    updateVo = null;
                    break;
                }
                updateVo = it.next();
                String str2 = updateVo.apk_name;
                if (!h.isEmpty(str2) && str2.equals(str)) {
                    break;
                }
            }
        }
        if (updateVo != null) {
            tv.chushou.a.a.b.a.eHz().M(new Runnable() { // from class: com.kascend.chushou.toolkit.d.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(updateVo);
                }
            });
        }
    }
}
