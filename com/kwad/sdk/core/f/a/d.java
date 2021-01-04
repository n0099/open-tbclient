package com.kwad.sdk.core.f.a;

import android.content.Context;
import android.database.Cursor;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f9434a;

    public d(Context context) {
        this.f9434a = context;
    }

    private String a(Cursor cursor) {
        String str;
        str = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            str = columnIndex > 0 ? cursor.getString(columnIndex) : "";
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
            }
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public java.lang.String a() {
        /*
            r9 = this;
            r6 = 0
            java.lang.String r7 = ""
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L43
            android.content.Context r0 = r9.f9434a     // Catch: java.lang.Throwable -> L43
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L43
            r2 = 0
            r3 = 0
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L43
            r5 = 0
            java.lang.String r8 = "oaid"
            r4[r5] = r8     // Catch: java.lang.Throwable -> L43
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = r9.a(r2)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = "MeizuDeviceIDHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
            r3.<init>()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r4 = "getOAID oaid:"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L6e
            java.lang.StringBuilder r3 = r3.append(r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L6e
            com.kwad.sdk.core.d.a.b(r1, r3)     // Catch: java.lang.Throwable -> L6e
            com.kwad.sdk.utils.w.a(r2)     // Catch: java.lang.Exception -> L4d
        L42:
            return r0
        L43:
            r1 = move-exception
            r2 = r6
            r0 = r7
        L46:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L68
            com.kwad.sdk.utils.w.a(r2)     // Catch: java.lang.Exception -> L4d
            goto L42
        L4d:
            r1 = move-exception
        L4e:
            java.lang.String r2 = "MeizuDeviceIDHelper"
            java.lang.String r3 = "getOAID service not found;"
            com.kwad.sdk.core.d.a.b(r2, r3)
            com.kwad.sdk.core.d.a.a(r1)
            goto L42
        L5b:
            r0 = move-exception
            r1 = r0
            r2 = r6
        L5e:
            com.kwad.sdk.utils.w.a(r2)     // Catch: java.lang.Exception -> L62
            throw r1     // Catch: java.lang.Exception -> L62
        L62:
            r1 = move-exception
            r0 = r7
            goto L4e
        L65:
            r0 = move-exception
            r1 = r0
            goto L5e
        L68:
            r1 = move-exception
            r7 = r0
            goto L5e
        L6b:
            r1 = move-exception
            r0 = r7
            goto L46
        L6e:
            r1 = move-exception
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.f.a.d.a():java.lang.String");
    }
}
