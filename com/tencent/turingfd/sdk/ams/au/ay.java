package com.tencent.turingfd.sdk.ams.au;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
/* loaded from: classes4.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f13800a = {"px", "dp", "sp", "pt", "in", "mm"};

    /* renamed from: b  reason: collision with root package name */
    public aw f13801b;
    public Map<String, String> c = new HashMap();
    public byte[] d;
    public String[] e;
    public int[] f;
    public int g;
    public int h;
    public int i;
    public int j;

    public final String a(int i) {
        if (i < 0 || i >= this.g) {
            return null;
        }
        return this.e[i];
    }

    public Document a(InputStream inputStream) throws IOException, ParserConfigurationException {
        String a2;
        String str;
        String format;
        byte[] bArr;
        aw awVar = new aw();
        this.f13801b = awVar;
        this.d = new byte[inputStream.available()];
        inputStream.read(this.d);
        inputStream.close();
        while (true) {
            int i = this.j;
            if (i >= this.d.length) {
                this.f13801b.a();
                return awVar.f13797b;
            }
            int b2 = b(i);
            if (b2 == -1) {
                this.f13801b.a();
            } else if (b2 == 524291) {
                aw awVar2 = this.f13801b;
                awVar2.f13797b = awVar2.c.newDocument();
                awVar2.f13796a.push(awVar2.f13797b);
                this.j += 8;
            } else if (b2 == 524672) {
                int b3 = b(this.j + 4);
                this.i = (b3 / 4) - 2;
                this.f = new int[this.i];
                for (int i2 = 0; i2 < this.i; i2++) {
                    this.f[i2] = b(this.j + ((i2 + 2) * 4));
                }
                this.j += b3;
            } else if (b2 != 1835009) {
                switch (b2) {
                    case 1048832:
                        a(true);
                        continue;
                    case 1048833:
                        a(false);
                        continue;
                    case 1048834:
                        int b4 = b(this.j + 16);
                        int b5 = b(this.j + 20);
                        int i3 = this.j + 28;
                        byte[] bArr2 = this.d;
                        int i4 = ((bArr2[i3 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((bArr2[i3 + 0] << 0) & 255);
                        String a3 = a(b5);
                        if (b4 == -1) {
                            a2 = "";
                            str = a3;
                        } else {
                            a2 = a(b4);
                            str = this.c.containsKey(a2) ? this.c.get(a2) + ':' + a3 : a3;
                        }
                        this.j += 36;
                        av[] avVarArr = new av[i4];
                        for (int i5 = 0; i5 < i4; i5++) {
                            int b6 = b(this.j);
                            int b7 = b(this.j + 4);
                            int b8 = b(this.j + 8);
                            int b9 = b(this.j + 12);
                            int b10 = b(this.j + 16);
                            av avVar = new av();
                            avVar.f13794a = a(b7);
                            if (b6 == -1) {
                                avVar.b(null);
                                avVar.a(null);
                            } else {
                                String a4 = a(b6);
                                if (this.c.containsKey(a4)) {
                                    avVar.b(a4);
                                    avVar.a(this.c.get(a4));
                                }
                            }
                            if (b8 == -1) {
                                switch (b9) {
                                    case 16777224:
                                        format = String.format("@id/0x%08X", Integer.valueOf(b10));
                                        break;
                                    case 33554440:
                                        format = String.format("?id/0x%08X", Integer.valueOf(b10));
                                        break;
                                    case 50331656:
                                        format = a(b10);
                                        break;
                                    case 67108872:
                                        format = Float.toString(Float.intBitsToFloat(b10));
                                        break;
                                    case 83886088:
                                        format = Integer.toString(b10 >> 8) + f13800a[b10 & 255];
                                        break;
                                    case 100663304:
                                        format = new DecimalFormat("#.##%").format(b10 / 2.147483647E9d);
                                        break;
                                    case 268435464:
                                    case 285212680:
                                        format = Integer.toString(b10);
                                        break;
                                    case 301989896:
                                        format = Boolean.toString(b10 != 0);
                                        break;
                                    case 469762056:
                                    case 486539272:
                                        format = String.format("#%08X", Integer.valueOf(b10));
                                        break;
                                    default:
                                        format = String.format("%08X/0x%08X", Integer.valueOf(b9), Integer.valueOf(b10));
                                        break;
                                }
                                avVar.c(format);
                            } else {
                                avVar.c(a(b8));
                            }
                            avVarArr[i5] = avVar;
                            this.j += 20;
                        }
                        this.f13801b.a(a2, a3, str, avVarArr);
                        continue;
                    case 1048835:
                        int b11 = b(this.j + 16);
                        a(b(this.j + 20));
                        if (b11 != -1) {
                            a(b11);
                        }
                        this.f13801b.f13796a.pop();
                        this.j += 24;
                        continue;
                    case 1048836:
                        String a5 = a(b(this.j + 16));
                        aw awVar3 = this.f13801b;
                        awVar3.f13796a.peek().appendChild(awVar3.f13797b.createCDATASection(a5));
                        this.j += 28;
                        continue;
                    default:
                        this.j += 4;
                        continue;
                }
            } else {
                int b12 = b(this.j + 4);
                this.g = b(this.j + 8);
                this.h = b(this.j + 12);
                int i6 = this.j;
                int b13 = b(i6 + 20);
                int b14 = b(this.j + 24);
                this.e = new String[this.g];
                for (int i7 = 0; i7 < this.g; i7++) {
                    int b15 = b(this.j + ((i7 + 7) * 4)) + b13 + i6;
                    String[] strArr = this.e;
                    byte[] bArr3 = this.d;
                    int i8 = b15 + 1;
                    if (bArr3[i8] == bArr3[b15]) {
                        int i9 = bArr3[b15];
                        bArr = new byte[i9];
                        for (int i10 = 0; i10 < i9; i10++) {
                            bArr[i10] = this.d[b15 + 2 + i10];
                        }
                    } else {
                        int i11 = ((bArr3[i8] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr3[b15] & 255);
                        bArr = new byte[i11];
                        for (int i12 = 0; i12 < i11; i12++) {
                            bArr[i12] = this.d[b15 + 2 + (i12 * 2)];
                        }
                    }
                    strArr[i7] = new String(bArr);
                }
                if (b14 > 0) {
                    for (int i13 = 0; i13 < this.h; i13++) {
                    }
                }
                this.j += b12;
            }
        }
    }

    public final void a(boolean z) {
        int b2 = b(this.j + 16);
        String a2 = a(b(this.j + 20));
        String a3 = a(b2);
        if (z) {
            this.f13801b.a(a3, a2);
            this.c.put(a2, a3);
        } else {
            this.f13801b.b(a3, a2);
            this.c.remove(a2);
        }
        this.j += 24;
    }

    public final int b(int i) {
        byte[] bArr = this.d;
        return ((bArr[i + 0] << 0) & 255) | ((bArr[i + 3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i + 2] << 16) & 16711680) | ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }
}
