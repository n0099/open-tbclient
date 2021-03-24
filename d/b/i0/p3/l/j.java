package d.b.i0.p3.l;

import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes5.dex */
public class j {
    public static final int[] q = {0, 48000, SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 37800, 32000, 22050, 48000, SwanAudioPlayer.DEFAULT_SAMPLE_RATE};
    public static final int[] r = {1, 16, 20, 16, 16, 15, 16, 15};
    public static final int[] s = {8, 18, 27, 8, 8, 8, 10, 9};
    public static final double[][] t = {new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};

    /* renamed from: a  reason: collision with root package name */
    public ByteOrder f59114a = ByteOrder.LITTLE_ENDIAN;

    /* renamed from: b  reason: collision with root package name */
    public k f59115b = new k();

    /* renamed from: c  reason: collision with root package name */
    public double f59116c = 150.0d;

    /* renamed from: d  reason: collision with root package name */
    public double f59117d = 200.0d;

    /* renamed from: e  reason: collision with root package name */
    public int f59118e = 1;

    /* renamed from: f  reason: collision with root package name */
    public double[][] f59119f;

    /* renamed from: g  reason: collision with root package name */
    public int f59120g;

    /* renamed from: h  reason: collision with root package name */
    public int f59121h;
    public int i;
    public int j;
    public double[] k;
    public int l;
    public boolean m;
    public int n;
    public long o;
    public long p;

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, int i6, double d2, int i7, boolean z) throws Exception {
        int i8;
        int i9;
        int i10;
        double[] dArr;
        double d3;
        int i11;
        String str;
        int i12;
        double[] dArr2;
        int i13;
        int i14;
        j jVar;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        this.m = false;
        double[] dArr3 = {0.0d};
        if (i7 >= 0 && i7 <= 4) {
            this.m = z;
            if (!z) {
                System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
            }
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
                throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
            }
            int i21 = i4;
            if (i21 == -1) {
                i21 = i3 != 1 ? i3 : 2;
                if (i21 == 4) {
                    i8 = i2;
                    i21 = 3;
                    i8 = i8 == -1 ? i : i8;
                    i9 = i7 != -1 ? i21 < i3 ? i21 == 1 ? 4 : 3 : 1 : i7;
                    String str2 = "\n";
                    if (this.m) {
                        String[] strArr = {"none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)"};
                        String[] strArr2 = {"rectangular", "triangular", "gaussian"};
                        dArr = dArr3;
                        System.err.printf("frequency : %d -> %d\n", Integer.valueOf(i), Integer.valueOf(i8));
                        System.err.printf("attenuation : %gdB\n", Double.valueOf(d2));
                        System.err.printf("bits per sample : %d -> %d\n", Integer.valueOf(i3 * 8), Integer.valueOf(i21 * 8));
                        System.err.printf("nchannels : %d\n", Integer.valueOf(i5));
                        PrintStream printStream = System.err;
                        double d4 = i6;
                        i10 = i21;
                        double d5 = i3;
                        Double.isNaN(d4);
                        Double.isNaN(d5);
                        double d6 = d4 / d5;
                        double d7 = i5;
                        Double.isNaN(d7);
                        double d8 = d6 / d7;
                        double d9 = i;
                        Double.isNaN(d9);
                        printStream.printf("length : %d bytes, %g secs\n", Integer.valueOf(i6), Double.valueOf(d8 / d9));
                        if (i9 == 0) {
                            i20 = 0;
                            System.err.printf("dither type : none\n", new Object[0]);
                        } else {
                            i20 = 0;
                            System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", strArr[i9], strArr2[0], Double.valueOf(0.18d));
                        }
                        str2 = "\n";
                        System.err.printf(str2, new Object[i20]);
                    } else {
                        i10 = i21;
                        dArr = dArr3;
                    }
                    if (i9 == 0) {
                        int i22 = i10;
                        if (i22 == 1) {
                            i17 = com.alipay.sdk.encrypt.a.f1896g;
                            i15 = 127;
                            i16 = 2;
                        } else {
                            i15 = 0;
                            i16 = 2;
                            i17 = 0;
                        }
                        if (i22 == i16) {
                            i17 = -32768;
                            i15 = 32767;
                        }
                        if (i22 == 3) {
                            i17 = -8388608;
                            i15 = 8388607;
                        }
                        if (i22 == 4) {
                            i19 = Integer.MIN_VALUE;
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i15;
                            i19 = i17;
                        }
                        str = str2;
                        i12 = i22;
                        dArr2 = dArr;
                        d3 = d2;
                        i11 = i8;
                        h(i8, i5, i19, i18, i9, 0, 0.18d);
                    } else {
                        d3 = d2;
                        i11 = i8;
                        str = str2;
                        i12 = i10;
                        dArr2 = dArr;
                    }
                    if (i >= i11) {
                        int i23 = i11;
                        i13 = i5;
                        dArr2[0] = n(inputStream, outputStream, i5, i3, i12, i, i23, Math.pow(10.0d, (-d3) / 20.0d), (i6 / i3) / i13, false, i9);
                    } else {
                        int i24 = i11;
                        i13 = i5;
                        if (i > i24) {
                            dArr2[0] = d(inputStream, outputStream, i5, i3, i12, i, i24, Math.pow(10.0d, (-d3) / 20.0d), (i6 / i3) / i13, false, i9);
                        } else {
                            i14 = 0;
                            dArr2[0] = i(inputStream, outputStream, i5, i3, i12, Math.pow(10.0d, (-d3) / 20.0d), (i6 / i3) / i13, false, i9);
                            jVar = this;
                            if (!jVar.m) {
                                System.err.printf(str, new Object[i14]);
                            }
                            if (i9 != 0) {
                                jVar.j(i13);
                            }
                            if (dArr2[i14] <= 1.0d || jVar.m) {
                                return;
                            }
                            PrintStream printStream2 = System.err;
                            Object[] objArr = new Object[1];
                            objArr[i14] = Double.valueOf(Math.log10(dArr2[i14]) * 20.0d);
                            printStream2.printf("clipping detected : %gdB\n", objArr);
                            return;
                        }
                    }
                    jVar = this;
                    i14 = 0;
                    if (!jVar.m) {
                    }
                    if (i9 != 0) {
                    }
                    if (dArr2[i14] <= 1.0d) {
                        return;
                    }
                    return;
                }
            }
            i8 = i2;
            if (i8 == -1) {
            }
            if (i7 != -1) {
            }
            String str22 = "\n";
            if (this.m) {
            }
            if (i9 == 0) {
            }
            if (i >= i11) {
            }
            jVar = this;
            i14 = 0;
            if (!jVar.m) {
            }
            if (i9 != 0) {
            }
            if (dArr2[i14] <= 1.0d) {
            }
        } else {
            throw new IllegalArgumentException("unrecognized dither type : " + i7);
        }
    }

    public final int a(double d2) {
        return (int) (d2 >= 0.0d ? d2 + 0.5d : d2 - 0.5d);
    }

    public final double b(double d2) {
        if (d2 <= 21.0d) {
            return 0.0d;
        }
        if (d2 <= 50.0d) {
            double d3 = d2 - 21.0d;
            return (Math.pow(d3, 0.4d) * 0.5842d) + (d3 * 0.07886d);
        }
        return (d2 - 8.7d) * 0.1102d;
    }

    public int c(double d2, double[] dArr, int i, int i2) {
        int i3;
        double a2;
        if (i == 1) {
            double[] dArr2 = this.k;
            int i4 = this.l;
            this.l = i4 + 1;
            double d3 = d2 + dArr2[i4 & 65535];
            int i5 = this.i;
            if (d3 < i5) {
                double d4 = i5;
                Double.isNaN(d4);
                double d5 = d3 / d4;
                if (dArr[0] >= d5) {
                    d5 = dArr[0];
                }
                dArr[0] = d5;
                d3 = this.i;
            }
            int i6 = this.j;
            if (d3 > i6) {
                double d6 = i6;
                Double.isNaN(d6);
                double d7 = d3 / d6;
                if (dArr[0] >= d7) {
                    d7 = dArr[0];
                }
                dArr[0] = d7;
                d3 = this.j;
            }
            return a(d3);
        }
        double d8 = 0.0d;
        int i7 = 0;
        while (true) {
            i3 = this.f59121h;
            if (i7 >= i3) {
                break;
            }
            d8 += t[this.f59120g][i7] * this.f59119f[i2][i7];
            i7++;
        }
        double d9 = d2 + d8;
        double[] dArr3 = this.k;
        int i8 = this.l;
        this.l = i8 + 1;
        double d10 = dArr3[65535 & i8] + d9;
        for (int i9 = i3 - 2; i9 >= 0; i9--) {
            double[][] dArr4 = this.f59119f;
            dArr4[i2][i9 + 1] = dArr4[i2][i9];
        }
        int i10 = this.i;
        if (d10 < i10) {
            double d11 = i10;
            Double.isNaN(d11);
            double d12 = d10 / d11;
            if (dArr[0] >= d12) {
                d12 = dArr[0];
            }
            dArr[0] = d12;
            a2 = this.i;
            double[][] dArr5 = this.f59119f;
            double[] dArr6 = dArr5[i2];
            Double.isNaN(a2);
            dArr6[0] = a2 - d9;
            if (dArr5[i2][0] > 1.0d) {
                dArr5[i2][0] = 1.0d;
            }
            double[][] dArr7 = this.f59119f;
            if (dArr7[i2][0] < -1.0d) {
                dArr7[i2][0] = -1.0d;
            }
        } else {
            int i11 = this.j;
            if (d10 > i11) {
                double d13 = i11;
                Double.isNaN(d13);
                double d14 = d10 / d13;
                if (dArr[0] >= d14) {
                    d14 = dArr[0];
                }
                dArr[0] = d14;
                a2 = this.j;
                double[][] dArr8 = this.f59119f;
                double[] dArr9 = dArr8[i2];
                Double.isNaN(a2);
                dArr9[0] = a2 - d9;
                if (dArr8[i2][0] > 1.0d) {
                    dArr8[i2][0] = 1.0d;
                }
                double[][] dArr10 = this.f59119f;
                if (dArr10[i2][0] < -1.0d) {
                    dArr10[i2][0] = -1.0d;
                }
            } else {
                a2 = a(d10);
                double[] dArr11 = this.f59119f[i2];
                Double.isNaN(a2);
                dArr11[0] = a2 - d9;
            }
        }
        return (int) a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0484 A[LOOP:4: B:99:0x0480->B:101:0x0484, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0491 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0874  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x08df  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x096d A[LOOP:14: B:266:0x096b->B:267:0x096d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x098f A[LOOP:15: B:269:0x098d->B:270:0x098f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x09a0  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x09af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double d(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, double d2, int i6, boolean z, int i7) throws IOException {
        int i8;
        int i9;
        double d3;
        double d4;
        double d5;
        int i10;
        int[] iArr;
        int i11;
        double[] dArr;
        int i12;
        int i13;
        int[] iArr2;
        int i14;
        double[][] dArr2;
        int i15;
        int i16;
        int[] iArr3;
        int i17;
        j jVar;
        int i18;
        double[][] dArr3;
        int i19;
        ByteBuffer byteBuffer;
        double d6;
        int i20;
        int i21;
        ByteBuffer byteBuffer2;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        double[] dArr4;
        int i28;
        double d7;
        ByteBuffer byteBuffer3;
        j jVar2;
        ByteBuffer byteBuffer4;
        int i29;
        int i30;
        int a2;
        char c2;
        int i31;
        int i32;
        ByteBuffer byteBuffer5;
        int a3;
        char c3;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        double[] dArr5;
        int i39;
        double d8;
        ByteBuffer byteBuffer6;
        int i40;
        int a4;
        char c4;
        double[] dArr6;
        int i41;
        int i42;
        int i43;
        int i44;
        int i45;
        int i46;
        int i47;
        int i48;
        int i49;
        int i50 = i5;
        double[] dArr7 = {0.0d};
        int i51 = this.f59118e;
        double d9 = this.f59116c;
        int e2 = e(i4, i50);
        int i52 = i50 / e2;
        if (i52 == 1) {
            i8 = 1;
        } else if (i52 % 2 == 0) {
            i8 = 2;
        } else if (i52 % 3 != 0) {
            throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i52)));
        } else {
            i8 = 3;
        }
        int i53 = i4 * i8;
        double d10 = d9 <= 21.0d ? 0.9222d : (d9 - 7.95d) / 14.36d;
        int i54 = 1;
        while (true) {
            int i55 = i51 * i54;
            if (i55 % 2 == 0) {
                i55--;
            }
            i9 = i55;
            d3 = i53;
            Double.isNaN(d3);
            double d11 = i9 - 1;
            Double.isNaN(d11);
            double d12 = (d3 * d10) / d11;
            d4 = i50;
            Double.isNaN(d4);
            d5 = (d4 - d12) / 2.0d;
            i10 = i8;
            if (d12 < this.f59117d) {
                break;
            }
            i54 *= 2;
            i50 = i5;
            d9 = d9;
            i8 = i10;
        }
        double b2 = b(d9);
        double a5 = f.a(b2);
        int i56 = 1;
        while (i56 < i9) {
            i56 *= 2;
        }
        int i57 = i56 * 2;
        double[] dArr8 = new double[i57];
        int i58 = i9 / 2;
        int i59 = -i58;
        while (i59 <= i58) {
            int i60 = i59 + i58;
            int i61 = i58;
            int i62 = i59;
            int i63 = i9;
            double[] dArr9 = dArr8;
            int i64 = i9;
            int i65 = i57;
            int i66 = i53;
            int i67 = i10;
            Double.isNaN(d3);
            double d13 = i4;
            Double.isNaN(d13);
            double o = ((o(i59, i63, b2, a5) * g(i62, d5, d3)) * d3) / d13;
            double d14 = i65;
            Double.isNaN(d14);
            dArr9[i60] = (o / d14) * 2.0d;
            i59 = i62 + 1;
            i10 = i67;
            i57 = i65;
            dArr7 = dArr7;
            dArr8 = dArr9;
            i58 = i61;
            i9 = i64;
            i53 = i66;
        }
        int i68 = i59;
        double[] dArr10 = dArr8;
        double[] dArr11 = dArr7;
        int i69 = i53;
        int i70 = i9;
        int i71 = i57;
        int i72 = i10;
        int[] iArr4 = new int[(int) (Math.sqrt(i71) + 2.0d)];
        iArr4[0] = 0;
        int i73 = i71 / 2;
        double[] dArr12 = new double[i73];
        this.f59115b.B(i71, 1, dArr10, iArr4, dArr12);
        if (i72 == 1) {
            int i74 = (i4 / e2) * i50;
            int[] iArr5 = {i4 / i50};
            double[][] dArr13 = (double[][]) Array.newInstance(double.class, 1, 1);
            dArr13[0][0] = 1.0d;
            dArr = dArr12;
            iArr3 = new int[]{0};
            iArr = iArr4;
            i12 = i73;
            i11 = i71;
            i16 = 1;
            i14 = 1;
            dArr2 = dArr13;
            iArr2 = iArr5;
            i15 = i74;
            i17 = i68;
            i13 = 1;
        } else {
            double d15 = this.f59116c;
            int i75 = (i4 / e2) * i50;
            int i76 = i4 / 2;
            int i77 = (i69 / 2) - i76;
            double[] dArr14 = dArr12;
            iArr = iArr4;
            int i78 = i73;
            double d16 = i77 * 2;
            Double.isNaN(d16);
            double d17 = d16 / 2.0d;
            double d18 = i76;
            i11 = i71;
            double d19 = i77;
            Double.isNaN(d19);
            Double.isNaN(d18);
            double d20 = (d19 / 2.0d) + d18;
            double d21 = d15 > 21.0d ? (d15 - 7.95d) / 14.36d : 0.9222d;
            double d22 = i75;
            Double.isNaN(d22);
            int i79 = (int) (((d22 / d17) * d21) + 1.0d);
            if (i79 % 2 == 0) {
                i79++;
            }
            int i80 = i79;
            double b3 = b(d15);
            double a6 = f.a(b3);
            int i81 = i75 / i69;
            int i82 = (i80 / i81) + 1;
            int[] iArr6 = new int[i81];
            for (int i83 = 0; i83 < i81; i83++) {
                iArr6[i83] = i81 - (((i75 / i50) * i83) % i81);
                if (iArr6[i83] == i81) {
                    iArr6[i83] = 0;
                }
            }
            int[] iArr7 = new int[i81];
            int i84 = 0;
            while (i84 < i81) {
                iArr7[i84] = (((i75 / i50) - iArr6[i84]) / i81) + 1;
                int i85 = i84 + 1;
                if (iArr6[i85 == i81 ? 0 : i85] == 0) {
                    iArr7[i84] = iArr7[i84] - 1;
                }
                i84 = i85;
            }
            double[][] dArr15 = (double[][]) Array.newInstance(double.class, i81, i82);
            int i86 = i80 / 2;
            int i87 = -i86;
            while (i87 <= i86) {
                int i88 = i87 + i86;
                int i89 = i87;
                double d23 = d22;
                Double.isNaN(d23);
                Double.isNaN(d3);
                dArr15[i88 % i81][i88 / i81] = ((o(i87, i80, b3, a6) * g(i89, d20, d23)) * d23) / d3;
                i87 = i89 + 1;
                iArr7 = iArr7;
                i86 = i86;
                i75 = i75;
                i81 = i81;
                dArr14 = dArr14;
                iArr6 = iArr6;
                d22 = d23;
                i78 = i78;
            }
            int i90 = i87;
            int[] iArr8 = iArr6;
            dArr = dArr14;
            i12 = i78;
            int i91 = i75;
            int i92 = i81;
            i13 = i80;
            iArr2 = iArr7;
            i14 = i82;
            dArr2 = dArr15;
            i15 = i91;
            i16 = i92;
            iArr3 = iArr8;
            i17 = i90;
        }
        k();
        double[][] dArr16 = (double[][]) Array.newInstance(double.class, i, i11);
        int i93 = i14 + 1;
        int i94 = i93 + i12;
        int i95 = i17;
        double[][] dArr17 = (double[][]) Array.newInstance(double.class, i, i94);
        int i96 = ((i12 / i72) + i72 + 1) * i;
        int i97 = i2;
        ByteBuffer allocate = ByteBuffer.allocate(i96 * i97);
        int i98 = i14;
        double[][] dArr18 = dArr2;
        double d24 = i12;
        Double.isNaN(d24);
        Double.isNaN(d4);
        int i99 = i93;
        int i100 = i16;
        double d25 = i4;
        Double.isNaN(d25);
        double d26 = d25;
        double d27 = ((d24 * d4) / d25) + 1.0d;
        int i101 = i3 * i;
        int[] iArr9 = iArr2;
        double d28 = i101;
        Double.isNaN(d28);
        int[] iArr10 = iArr3;
        int i102 = i12;
        ByteBuffer allocate2 = ByteBuffer.allocate((int) (d27 * d28));
        double[] dArr19 = new double[i96];
        double d29 = d28;
        double d30 = i;
        Double.isNaN(d30);
        double[] dArr20 = new double[(int) (d30 * d27)];
        double d31 = i70;
        Double.isNaN(d31);
        Double.isNaN(d3);
        Double.isNaN(d4);
        double d32 = i13;
        Double.isNaN(d32);
        int i103 = i101;
        double d33 = i15;
        Double.isNaN(d33);
        Double.isNaN(d4);
        int i104 = (int) (((d31 / 2.0d) / (d3 / d4)) + ((d32 / 2.0d) / (d33 / d4)));
        int i105 = i95;
        ByteBuffer byteBuffer7 = allocate;
        int i106 = 0;
        int i107 = 0;
        int i108 = 0;
        int i109 = 0;
        int i110 = 0;
        boolean z2 = true;
        int i111 = i6;
        int i112 = 0;
        while (true) {
            int i113 = (((i102 + 0) - 1) / i72) + 1;
            int i114 = i105;
            if (i113 + i106 > i111) {
                i113 = i111 - i106;
            }
            byteBuffer7.position(0);
            int i115 = i97 * i;
            int i116 = i111;
            byteBuffer7.limit(i115 * i113);
            byte[] bArr = new byte[byteBuffer7.limit()];
            int i117 = i104;
            int read = inputStream.read(bArr);
            int i118 = i107;
            int i119 = read < 0 ? 0 : read;
            int i120 = i119 < byteBuffer7.limit() ? ((i119 / i97) * i) + i106 : i116;
            byteBuffer7.limit(i119);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(i119);
            wrap.flip();
            int i121 = i119 / i115;
            if (i97 == 1) {
                jVar = this;
                i18 = i108;
                dArr3 = dArr17;
                i19 = i15;
                byteBuffer = allocate2;
                d6 = d29;
                i20 = i72;
                i21 = 0;
                while (i21 < i121 * i) {
                    double d34 = (wrap.get(i21) & 255) + com.alipay.sdk.encrypt.a.f1896g;
                    Double.isNaN(d34);
                    dArr19[(i * 0) + i21] = d34 * 0.007874015748031496d;
                    i21++;
                    wrap = wrap;
                }
            } else if (i97 != 2) {
                if (i97 == 3) {
                    jVar = this;
                    i19 = i15;
                    byteBuffer = allocate2;
                    d6 = d29;
                    i21 = 0;
                    while (i21 < i121 * i) {
                        int i122 = i21 * 3;
                        int i123 = i108;
                        double d35 = ((wrap.get(i122 + 1) & 255) << 8) | ((wrap.get(i122) & 255) << 0) | ((wrap.get(i122 + 2) & 255) << 16);
                        Double.isNaN(d35);
                        dArr19[(i * 0) + i21] = d35 * 1.1920930376163766E-7d;
                        i21++;
                        i72 = i72;
                        i108 = i123;
                    }
                    i18 = i108;
                    i20 = i72;
                    byteBuffer2 = wrap;
                } else if (i97 != 4) {
                    jVar = this;
                    byteBuffer2 = wrap;
                    i18 = i108;
                    dArr3 = dArr17;
                    i19 = i15;
                    byteBuffer = allocate2;
                    d6 = d29;
                    i21 = i114;
                    i20 = i72;
                    while (i21 < i * i113) {
                        dArr19[i21] = 0.0d;
                        i21++;
                    }
                    int i124 = i106 + i121;
                    boolean z3 = inputStream.available() >= 0 || i124 >= i120;
                    int i125 = i110;
                    int i126 = i118;
                    i22 = 0;
                    while (i22 < i) {
                        int i127 = i102;
                        int i128 = 0;
                        int i129 = 0;
                        while (i128 < i127) {
                            dArr16[i22][i128] = dArr19[(i129 * i) + i22];
                            int i130 = i128 + 1;
                            while (true) {
                                i49 = i128 + i20;
                                if (i130 < i49) {
                                    dArr16[i22][i130] = 0.0d;
                                    i130++;
                                }
                            }
                            i129++;
                            i128 = i49;
                        }
                        int i131 = i11;
                        for (int i132 = i127; i132 < i131; i132++) {
                            dArr16[i22][i132] = 0.0d;
                        }
                        jVar.f59115b.B(i131, 1, dArr16[i22], iArr, dArr);
                        dArr16[i22][0] = dArr10[0] * dArr16[i22][0];
                        dArr16[i22][1] = dArr10[1] * dArr16[i22][1];
                        for (int i133 = 1; i133 < i127; i133++) {
                            int i134 = i133 * 2;
                            int i135 = i134 + 1;
                            dArr16[i22][i134] = (dArr10[i134] * dArr16[i22][i134]) - (dArr10[i135] * dArr16[i22][i135]);
                            dArr16[i22][i135] = (dArr10[i135] * dArr16[i22][i134]) + (dArr10[i134] * dArr16[i22][i135]);
                        }
                        jVar.f59115b.B(i131, -1, dArr16[i22], iArr, dArr);
                        int i136 = 0;
                        while (i136 < i127) {
                            double[] dArr21 = dArr3[i22];
                            int i137 = i99 + i136;
                            dArr21[i137] = dArr21[i137] + dArr16[i22][i136];
                            i136++;
                        }
                        int i138 = i19 / i69;
                        int i139 = i109 / i138;
                        if (i109 % i138 != 0) {
                            i139++;
                        }
                        int length = (dArr3[0].length * i22) + i139;
                        int i140 = i136;
                        int i141 = i118;
                        int i142 = 0;
                        for (char c5 = 0; length - (dArr3[c5].length * i22) < i127 + 1; c5 = 0) {
                            int i143 = iArr10[i141];
                            int i144 = iArr9[i141] + length;
                            i141++;
                            int i145 = i131;
                            int i146 = i100;
                            if (i141 == i146) {
                                i141 = 0;
                            }
                            i100 = i146;
                            double d36 = 0.0d;
                            int i147 = i98;
                            int i148 = 0;
                            while (i148 < i147) {
                                d36 += dArr18[i143][i148] * dArr3[length / dArr3[0].length][length % dArr3[0].length];
                                length++;
                                i148++;
                                i143 = i143;
                                i141 = i141;
                            }
                            dArr20[0 + (i142 * i) + i22] = d36;
                            i142++;
                            i140 = i148;
                            i98 = i147;
                            length = i144;
                            i131 = i145;
                        }
                        i11 = i131;
                        i22++;
                        jVar = this;
                        i126 = i141;
                        i102 = i127;
                        i125 = i142;
                        i21 = i140;
                    }
                    int i149 = i98;
                    int i150 = i102;
                    int i151 = i109 + ((i19 / i5) * i125);
                    byteBuffer.clear();
                    if (z) {
                        i21 = 0;
                        while (i21 < i125 * i) {
                            double d37 = dArr20[i21] > 0.0d ? dArr20[i21] : -dArr20[i21];
                            if (dArr11[0] >= d37) {
                                d37 = dArr11[0];
                            }
                            dArr11[0] = d37;
                            byteBuffer.asDoubleBuffer().put(i21, dArr20[i21]);
                            i21++;
                        }
                    } else {
                        if (i3 == 1) {
                            i23 = i103;
                            i24 = i150;
                            i25 = i149;
                            i26 = i126;
                            i27 = i20;
                            dArr4 = dArr19;
                            i28 = i100;
                            d7 = d26;
                            byteBuffer3 = byteBuffer;
                            jVar2 = this;
                            int i152 = i99;
                            byteBuffer4 = byteBuffer2;
                            i29 = i152;
                            double d38 = d2 * 127.0d;
                            i30 = 0;
                            int i153 = 0;
                            while (i30 < i125 * i) {
                                if (i7 != 0) {
                                    a2 = c(dArr20[i30] * d38, dArr11, i7, i153);
                                } else {
                                    a2 = jVar2.a(dArr20[i30] * d38);
                                    if (a2 < -128) {
                                        double d39 = a2;
                                        Double.isNaN(d39);
                                        double d40 = d39 / (-128.0d);
                                        c2 = 0;
                                        if (dArr11[0] >= d40) {
                                            d40 = dArr11[0];
                                        }
                                        dArr11[0] = d40;
                                        a2 = com.alipay.sdk.encrypt.a.f1896g;
                                    } else {
                                        c2 = 0;
                                    }
                                    if (127 < a2) {
                                        double d41 = a2;
                                        Double.isNaN(d41);
                                        double d42 = d41 / 127.0d;
                                        if (dArr11[c2] >= d42) {
                                            d42 = dArr11[c2];
                                        }
                                        dArr11[c2] = d42;
                                        a2 = 127;
                                    }
                                }
                                byteBuffer3.put(i30, (byte) (a2 + 128));
                                int i154 = i153 + 1;
                                i153 = i154 == i ? 0 : i154;
                                i30++;
                            }
                        } else if (i3 == 2) {
                            i23 = i103;
                            i24 = i150;
                            i25 = i149;
                            i26 = i126;
                            i27 = i20;
                            dArr4 = dArr19;
                            i28 = i100;
                            d7 = d26;
                            ByteBuffer byteBuffer8 = byteBuffer;
                            jVar2 = this;
                            int i155 = i99;
                            byteBuffer4 = byteBuffer2;
                            i29 = i155;
                            double d43 = d2 * 32767.0d;
                            int i156 = 0;
                            int i157 = 0;
                            while (i156 < i125 * i) {
                                if (i7 != 0) {
                                    i32 = i156;
                                    byteBuffer5 = byteBuffer8;
                                    a3 = c(dArr20[i156] * d43, dArr11, i7, i157);
                                } else {
                                    i32 = i156;
                                    byteBuffer5 = byteBuffer8;
                                    a3 = jVar2.a(dArr20[i32] * d43);
                                    if (a3 < -32768) {
                                        double d44 = a3;
                                        Double.isNaN(d44);
                                        double d45 = d44 / (-32768.0d);
                                        c3 = 0;
                                        if (dArr11[0] >= d45) {
                                            d45 = dArr11[0];
                                        }
                                        dArr11[0] = d45;
                                        a3 = -32768;
                                    } else {
                                        c3 = 0;
                                    }
                                    if (32767 < a3) {
                                        double d46 = a3;
                                        Double.isNaN(d46);
                                        double d47 = d46 / 32767.0d;
                                        if (dArr11[c3] >= d47) {
                                            d47 = dArr11[c3];
                                        }
                                        dArr11[c3] = d47;
                                        a3 = 32767;
                                    }
                                }
                                byteBuffer5.order(jVar2.f59114a).asShortBuffer().put(i32, (short) a3);
                                int i158 = i157 + 1;
                                i157 = i158 == i ? 0 : i158;
                                i156 = i32 + 1;
                                byteBuffer8 = byteBuffer5;
                            }
                            i30 = i156;
                            byteBuffer3 = byteBuffer8;
                        } else if (i3 == 3) {
                            double d48 = d2 * 8388607.0d;
                            int i159 = 0;
                            int i160 = 0;
                            while (i159 < i125 * i) {
                                if (i7 != 0) {
                                    i34 = i159;
                                    i37 = i126;
                                    i38 = i20;
                                    dArr5 = dArr19;
                                    d8 = d26;
                                    int i161 = i99;
                                    byteBuffer6 = byteBuffer2;
                                    i40 = i161;
                                    i33 = i103;
                                    i35 = i150;
                                    i39 = i100;
                                    i36 = i149;
                                    a4 = c(dArr20[i159] * d48, dArr11, i7, i160);
                                } else {
                                    i33 = i103;
                                    i34 = i159;
                                    i35 = i150;
                                    i36 = i149;
                                    i37 = i126;
                                    i38 = i20;
                                    dArr5 = dArr19;
                                    i39 = i100;
                                    d8 = d26;
                                    int i162 = i99;
                                    byteBuffer6 = byteBuffer2;
                                    i40 = i162;
                                    a4 = a(dArr20[i34] * d48);
                                    if (a4 < -8388608) {
                                        double d49 = a4;
                                        Double.isNaN(d49);
                                        double d50 = d49 / (-8388608.0d);
                                        c4 = 0;
                                        if (dArr11[0] >= d50) {
                                            d50 = dArr11[0];
                                        }
                                        dArr11[0] = d50;
                                        a4 = -8388608;
                                    } else {
                                        c4 = 0;
                                    }
                                    if (8388607 < a4) {
                                        double d51 = a4;
                                        Double.isNaN(d51);
                                        double d52 = d51 / 8388607.0d;
                                        if (dArr11[c4] >= d52) {
                                            d52 = dArr11[c4];
                                        }
                                        dArr11[c4] = d52;
                                        a4 = 8388607;
                                    }
                                }
                                int i163 = i34 * 3;
                                ByteBuffer byteBuffer9 = byteBuffer;
                                byteBuffer9.put(i163, (byte) (a4 & 255));
                                int i164 = a4 >> 8;
                                byteBuffer9.put(i163 + 1, (byte) (i164 & 255));
                                byteBuffer9.put(i163 + 2, (byte) ((i164 >> 8) & 255));
                                int i165 = i160 + 1;
                                i160 = i165 == i ? 0 : i165;
                                i159 = i34 + 1;
                                byteBuffer = byteBuffer9;
                                i126 = i37;
                                d26 = d8;
                                dArr19 = dArr5;
                                i20 = i38;
                                i103 = i33;
                                i100 = i39;
                                i149 = i36;
                                i150 = i35;
                                ByteBuffer byteBuffer10 = byteBuffer6;
                                i99 = i40;
                                byteBuffer2 = byteBuffer10;
                            }
                            i23 = i103;
                            i24 = i150;
                            i25 = i149;
                            i26 = i126;
                            i27 = i20;
                            dArr4 = dArr19;
                            i28 = i100;
                            d7 = d26;
                            jVar2 = this;
                            int i166 = i99;
                            byteBuffer4 = byteBuffer2;
                            i29 = i166;
                            i31 = i159;
                            byteBuffer3 = byteBuffer;
                            if (z2) {
                                dArr6 = dArr20;
                                i41 = i120;
                                i42 = i18;
                                if (i125 < i117) {
                                    i104 = i117 - i125;
                                } else if (z3) {
                                    double d53 = i124;
                                    Double.isNaN(d53);
                                    Double.isNaN(d4);
                                    Double.isNaN(d7);
                                    double d54 = (d53 * d4) / d7;
                                    if (d54 + 2.0d > (i42 + i125) - i117) {
                                        byteBuffer3.position(i23 * i117);
                                        int i167 = i125 - i117;
                                        byteBuffer3.limit(i23 * i167);
                                        jVar2.p(outputStream, byteBuffer3);
                                        i42 += i167;
                                        i104 = i117;
                                    } else {
                                        byteBuffer3.position(i23 * i117);
                                        double d55 = i42;
                                        Double.isNaN(d55);
                                        double floor = Math.floor(d54) + 2.0d + d55;
                                        double d56 = i125;
                                        Double.isNaN(d56);
                                        double d57 = i117;
                                        Double.isNaN(d57);
                                        Double.isNaN(d6);
                                        byteBuffer3.limit((int) (d6 * ((floor + d56) - d57)));
                                        jVar2.p(outputStream, byteBuffer3);
                                        break;
                                    }
                                } else {
                                    byteBuffer3.position(i23 * i117);
                                    byteBuffer3.limit(i23 * i125);
                                    jVar2.p(outputStream, byteBuffer3);
                                    i42 += i125 - i117;
                                    i104 = i117;
                                    z2 = false;
                                }
                            } else {
                                if (z3) {
                                    double d58 = i124;
                                    Double.isNaN(d58);
                                    Double.isNaN(d4);
                                    Double.isNaN(d7);
                                    double d59 = (d58 * d4) / d7;
                                    i48 = i18 + i125;
                                    dArr6 = dArr20;
                                    i41 = i120;
                                    if (d59 + 2.0d > i48) {
                                        byteBuffer3.position(0);
                                        byteBuffer3.limit(i23 * i125);
                                        jVar2.p(outputStream, byteBuffer3);
                                    } else {
                                        byteBuffer3.position(0);
                                        double d60 = i18;
                                        Double.isNaN(d60);
                                        Double.isNaN(d6);
                                        int floor2 = (int) (d6 * ((Math.floor(d59) + 2.0d) - d60));
                                        if (floor2 > 0) {
                                            byteBuffer3.limit(floor2);
                                            jVar2.p(outputStream, byteBuffer3);
                                        }
                                    }
                                } else {
                                    dArr6 = dArr20;
                                    i41 = i120;
                                    byteBuffer3.position(0);
                                    byteBuffer3.limit(i23 * i125);
                                    jVar2.p(outputStream, byteBuffer3);
                                    i48 = i18 + i125;
                                }
                                i42 = i48;
                                i104 = i117;
                            }
                            int i168 = i19 / i69;
                            i43 = (i151 - 1) / i168;
                            i44 = i24;
                            if (i43 > i44) {
                                i43 = i44;
                            }
                            i45 = 0;
                            while (i45 < i) {
                                System.arraycopy(dArr3[i45], i43, dArr3[i45], 0, i94 - i43);
                                i45++;
                                i31 = i31;
                                i42 = i42;
                            }
                            int i169 = i31;
                            int i170 = i42;
                            i109 = i151 - (i43 * i168);
                            for (i46 = 0; i46 < i; i46++) {
                                System.arraycopy(dArr16[i46], i44, dArr3[i46], i29, i44);
                            }
                            int i171 = i112 + 1;
                            if ((i112 & 7) == 7) {
                                double d61 = i124;
                                i47 = i41;
                                double d62 = i47;
                                Double.isNaN(d61);
                                Double.isNaN(d62);
                                jVar2.l(d61 / d62);
                            } else {
                                i47 = i41;
                            }
                            i105 = i169;
                            i111 = i47;
                            i112 = i171;
                            i106 = i124;
                            i102 = i44;
                            dArr20 = dArr6;
                            allocate2 = byteBuffer3;
                            i108 = i170;
                            i107 = i26;
                            byteBuffer7 = byteBuffer4;
                            d26 = d7;
                            dArr19 = dArr4;
                            i72 = i27;
                            i103 = i23;
                            i100 = i28;
                            i98 = i25;
                            d29 = d6;
                            dArr17 = dArr3;
                            i110 = i125;
                            i99 = i29;
                            i15 = i19;
                            i97 = i2;
                        }
                        i31 = i30;
                        if (z2) {
                        }
                        int i1682 = i19 / i69;
                        i43 = (i151 - 1) / i1682;
                        i44 = i24;
                        if (i43 > i44) {
                        }
                        i45 = 0;
                        while (i45 < i) {
                        }
                        int i1692 = i31;
                        int i1702 = i42;
                        i109 = i151 - (i43 * i1682);
                        while (i46 < i) {
                        }
                        int i1712 = i112 + 1;
                        if ((i112 & 7) == 7) {
                        }
                        i105 = i1692;
                        i111 = i47;
                        i112 = i1712;
                        i106 = i124;
                        i102 = i44;
                        dArr20 = dArr6;
                        allocate2 = byteBuffer3;
                        i108 = i1702;
                        i107 = i26;
                        byteBuffer7 = byteBuffer4;
                        d26 = d7;
                        dArr19 = dArr4;
                        i72 = i27;
                        i103 = i23;
                        i100 = i28;
                        i98 = i25;
                        d29 = d6;
                        dArr17 = dArr3;
                        i110 = i125;
                        i99 = i29;
                        i15 = i19;
                        i97 = i2;
                    }
                    i23 = i103;
                    i31 = i21;
                    i24 = i150;
                    i25 = i149;
                    i26 = i126;
                    i27 = i20;
                    dArr4 = dArr19;
                    i28 = i100;
                    d7 = d26;
                    byteBuffer3 = byteBuffer;
                    jVar2 = this;
                    int i172 = i99;
                    byteBuffer4 = byteBuffer2;
                    i29 = i172;
                    if (z2) {
                    }
                    int i16822 = i19 / i69;
                    i43 = (i151 - 1) / i16822;
                    i44 = i24;
                    if (i43 > i44) {
                    }
                    i45 = 0;
                    while (i45 < i) {
                    }
                    int i16922 = i31;
                    int i17022 = i42;
                    i109 = i151 - (i43 * i16822);
                    while (i46 < i) {
                    }
                    int i17122 = i112 + 1;
                    if ((i112 & 7) == 7) {
                    }
                    i105 = i16922;
                    i111 = i47;
                    i112 = i17122;
                    i106 = i124;
                    i102 = i44;
                    dArr20 = dArr6;
                    allocate2 = byteBuffer3;
                    i108 = i17022;
                    i107 = i26;
                    byteBuffer7 = byteBuffer4;
                    d26 = d7;
                    dArr19 = dArr4;
                    i72 = i27;
                    i103 = i23;
                    i100 = i28;
                    i98 = i25;
                    d29 = d6;
                    dArr17 = dArr3;
                    i110 = i125;
                    i99 = i29;
                    i15 = i19;
                    i97 = i2;
                } else {
                    i21 = 0;
                    while (i21 < i121 * i) {
                        int i173 = i15;
                        double d63 = wrap.order(this.f59114a).getInt(i21);
                        Double.isNaN(d63);
                        dArr19[(i * 0) + i21] = d63 * 4.656612875245797E-10d;
                        i21++;
                        d29 = d29;
                        i15 = i173;
                        allocate2 = allocate2;
                    }
                    jVar = this;
                    i19 = i15;
                    byteBuffer = allocate2;
                    d6 = d29;
                    byteBuffer2 = wrap;
                    i18 = i108;
                    i20 = i72;
                }
                dArr3 = dArr17;
                while (i21 < i * i113) {
                }
                int i1242 = i106 + i121;
                if (inputStream.available() >= 0) {
                }
                int i1252 = i110;
                int i1262 = i118;
                i22 = 0;
                while (i22 < i) {
                }
                int i1492 = i98;
                int i1502 = i102;
                int i1512 = i109 + ((i19 / i5) * i1252);
                byteBuffer.clear();
                if (z) {
                }
                i23 = i103;
                i31 = i21;
                i24 = i1502;
                i25 = i1492;
                i26 = i1262;
                i27 = i20;
                dArr4 = dArr19;
                i28 = i100;
                d7 = d26;
                byteBuffer3 = byteBuffer;
                jVar2 = this;
                int i1722 = i99;
                byteBuffer4 = byteBuffer2;
                i29 = i1722;
                if (z2) {
                }
                int i168222 = i19 / i69;
                i43 = (i1512 - 1) / i168222;
                i44 = i24;
                if (i43 > i44) {
                }
                i45 = 0;
                while (i45 < i) {
                }
                int i169222 = i31;
                int i170222 = i42;
                i109 = i1512 - (i43 * i168222);
                while (i46 < i) {
                }
                int i171222 = i112 + 1;
                if ((i112 & 7) == 7) {
                }
                i105 = i169222;
                i111 = i47;
                i112 = i171222;
                i106 = i1242;
                i102 = i44;
                dArr20 = dArr6;
                allocate2 = byteBuffer3;
                i108 = i170222;
                i107 = i26;
                byteBuffer7 = byteBuffer4;
                d26 = d7;
                dArr19 = dArr4;
                i72 = i27;
                i103 = i23;
                i100 = i28;
                i98 = i25;
                d29 = d6;
                dArr17 = dArr3;
                i110 = i1252;
                i99 = i29;
                i15 = i19;
                i97 = i2;
            } else {
                jVar = this;
                i18 = i108;
                i19 = i15;
                byteBuffer = allocate2;
                d6 = d29;
                i20 = i72;
                i21 = 0;
                while (i21 < i121 * i) {
                    double[][] dArr22 = dArr17;
                    double d64 = wrap.order(jVar.f59114a).asShortBuffer().get(i21);
                    Double.isNaN(d64);
                    dArr19[(i * 0) + i21] = d64 * 3.051850947599719E-5d;
                    i21++;
                    dArr17 = dArr22;
                }
                dArr3 = dArr17;
            }
            byteBuffer2 = wrap;
            while (i21 < i * i113) {
            }
            int i12422 = i106 + i121;
            if (inputStream.available() >= 0) {
            }
            int i12522 = i110;
            int i12622 = i118;
            i22 = 0;
            while (i22 < i) {
            }
            int i14922 = i98;
            int i15022 = i102;
            int i15122 = i109 + ((i19 / i5) * i12522);
            byteBuffer.clear();
            if (z) {
            }
            i23 = i103;
            i31 = i21;
            i24 = i15022;
            i25 = i14922;
            i26 = i12622;
            i27 = i20;
            dArr4 = dArr19;
            i28 = i100;
            d7 = d26;
            byteBuffer3 = byteBuffer;
            jVar2 = this;
            int i17222 = i99;
            byteBuffer4 = byteBuffer2;
            i29 = i17222;
            if (z2) {
            }
            int i1682222 = i19 / i69;
            i43 = (i15122 - 1) / i1682222;
            i44 = i24;
            if (i43 > i44) {
            }
            i45 = 0;
            while (i45 < i) {
            }
            int i1692222 = i31;
            int i1702222 = i42;
            i109 = i15122 - (i43 * i1682222);
            while (i46 < i) {
            }
            int i1712222 = i112 + 1;
            if ((i112 & 7) == 7) {
            }
            i105 = i1692222;
            i111 = i47;
            i112 = i1712222;
            i106 = i12422;
            i102 = i44;
            dArr20 = dArr6;
            allocate2 = byteBuffer3;
            i108 = i1702222;
            i107 = i26;
            byteBuffer7 = byteBuffer4;
            d26 = d7;
            dArr19 = dArr4;
            i72 = i27;
            i103 = i23;
            i100 = i28;
            i98 = i25;
            d29 = d6;
            dArr17 = dArr3;
            i110 = i12522;
            i99 = i29;
            i15 = i19;
            i97 = i2;
        }
        jVar2.l(1.0d);
        return dArr11[0];
    }

    public final int e(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    public byte[] f(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    public final double g(int i, double d2, double d3) {
        double d4 = 1.0d / d3;
        double d5 = 6.283185307179586d * d2;
        double d6 = i;
        Double.isNaN(d6);
        return d2 * 2.0d * d4 * m(d6 * d5 * d4);
    }

    public int h(int i, int i2, int i3, int i4, int i5, int i6, double d2) {
        int[] iArr = new int[97];
        int i7 = 1;
        while (i7 < 6 && i != q[i7]) {
            i7++;
        }
        if ((i5 == 3 || i5 == 4) && i7 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i));
        }
        i7 = (i5 == 2 || i7 == 6) ? 0 : 0;
        if (i5 == 4 && (i7 == 1 || i7 == 2)) {
            i7 += 5;
        }
        this.f59120g = i7;
        this.f59119f = new double[i2];
        this.f59121h = r[i7];
        for (int i8 = 0; i8 < i2; i8++) {
            this.f59119f[i8] = new double[this.f59121h];
        }
        this.i = i3;
        this.j = i4;
        this.k = new double[65536];
        Random random = new Random(System.currentTimeMillis());
        for (int i9 = 0; i9 < 97; i9++) {
            iArr[i9] = random.nextInt();
        }
        if (i6 == 0) {
            for (int i10 = 0; i10 < 65536; i10++) {
                int nextInt = random.nextInt() % 97;
                int i11 = iArr[nextInt];
                iArr[nextInt] = random.nextInt();
                double[] dArr = this.k;
                double d3 = i11;
                Double.isNaN(d3);
                dArr[i10] = ((d3 / 2.147483647E9d) - 0.5d) * d2;
            }
        } else if (i6 == 1) {
            for (int i12 = 0; i12 < 65536; i12++) {
                int nextInt2 = random.nextInt() % 97;
                int i13 = iArr[nextInt2];
                iArr[nextInt2] = random.nextInt();
                int nextInt3 = random.nextInt() % 97;
                int i14 = iArr[nextInt3];
                iArr[nextInt3] = random.nextInt();
                double[] dArr2 = this.k;
                double d4 = i13;
                Double.isNaN(d4);
                double d5 = i14;
                Double.isNaN(d5);
                dArr2[i12] = d2 * ((d4 / 2.147483647E9d) - (d5 / 2.147483647E9d));
            }
        } else if (i6 == 2) {
            boolean z = false;
            double d6 = 0.0d;
            double d7 = 0.0d;
            for (int i15 = 0; i15 < 65536; i15++) {
                if (!z) {
                    int nextInt4 = random.nextInt() % 97;
                    double d8 = iArr[nextInt4];
                    Double.isNaN(d8);
                    double d9 = d8 / 2.147483647E9d;
                    iArr[nextInt4] = random.nextInt();
                    if (d9 == 1.0d) {
                        d9 = 0.0d;
                    }
                    d6 = Math.sqrt(Math.log(1.0d - d9) * (-2.0d));
                    int nextInt5 = random.nextInt() % 97;
                    double d10 = iArr[nextInt5];
                    Double.isNaN(d10);
                    iArr[nextInt5] = random.nextInt();
                    d7 = 6.283185307179586d * (d10 / 2.147483647E9d);
                    this.k[i15] = d2 * d6 * Math.cos(d7);
                    z = true;
                } else {
                    this.k[i15] = d2 * d6 * Math.sin(d7);
                    z = false;
                }
            }
        }
        this.l = 0;
        if (i5 == 0 || i5 == 1) {
            return 1;
        }
        return s[this.f59120g];
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x026e A[EDGE_INSN: B:69:0x026e->B:66:0x026e ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double i(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, double d2, int i4, boolean z, int i5) throws IOException {
        double[] dArr;
        int i6;
        int i7;
        ByteBuffer wrap;
        double d3;
        ByteBuffer byteBuffer;
        double d4;
        int i8;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        int i9;
        int a2;
        int i10 = 1;
        int i11 = 0;
        double[] dArr2 = {0.0d};
        k();
        ByteBuffer allocate = z ? ByteBuffer.allocate(8) : null;
        int i12 = 4;
        ByteBuffer allocate2 = ByteBuffer.allocate(4);
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = i4 * i;
            if (i13 >= i15) {
                dArr = dArr2;
                break;
            }
            if (i2 == i10) {
                i6 = i15;
                i7 = i13;
                dArr = dArr2;
                allocate2.position(0);
                allocate2.limit(1);
                byte[] bArr = new byte[allocate2.limit()];
                inputStream.read(bArr);
                wrap = ByteBuffer.wrap(bArr);
                wrap.position(wrap.limit());
                wrap.flip();
                double d5 = wrap.get(0) + ByteCompanionObject.MIN_VALUE;
                Double.isNaN(d5);
                d3 = d5 * 0.007874015748031496d;
            } else if (i2 == 2) {
                i6 = i15;
                dArr = dArr2;
                allocate2.position(0);
                allocate2.limit(2);
                byte[] bArr2 = new byte[allocate2.limit()];
                inputStream.read(bArr2);
                wrap = ByteBuffer.wrap(bArr2);
                wrap.position(wrap.limit());
                wrap.flip();
                i7 = i13;
                double d6 = wrap.order(this.f59114a).asShortBuffer().get(0);
                Double.isNaN(d6);
                d3 = 3.051850947599719E-5d * d6;
            } else {
                if (i2 == 3) {
                    dArr = dArr2;
                    allocate2.position(i11);
                    allocate2.limit(3);
                    byte[] bArr3 = new byte[allocate2.limit()];
                    inputStream.read(bArr3);
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr3);
                    wrap2.position(wrap2.limit());
                    wrap2.flip();
                    i6 = i15;
                    double d7 = ((wrap2.get(1) & 255) << 8) | ((wrap2.get(i11) & 255) << i11) | ((wrap2.get(2) & 255) << 16);
                    Double.isNaN(d7);
                    d4 = 1.1920930376163766E-7d * d7;
                    byteBuffer = wrap2;
                    i7 = i13;
                } else if (i2 != i12) {
                    byteBuffer = allocate2;
                    i6 = i15;
                    i7 = i13;
                    dArr = dArr2;
                    d4 = 0.0d;
                } else {
                    allocate2.position(i11);
                    allocate2.limit(i12);
                    byte[] bArr4 = new byte[allocate2.limit()];
                    inputStream.read(bArr4);
                    wrap = ByteBuffer.wrap(bArr4);
                    wrap.position(wrap.limit());
                    wrap.flip();
                    dArr = dArr2;
                    double d8 = wrap.order(this.f59114a).asIntBuffer().get(i11);
                    Double.isNaN(d8);
                    d3 = d8 * 4.656612875245797E-10d;
                    i6 = i15;
                    i7 = i13;
                }
                if (inputStream.available() != 0) {
                    break;
                }
                double d9 = d4 * d2;
                if (z) {
                    i8 = i6;
                    ByteBuffer byteBuffer4 = allocate;
                    double d10 = d9 > 0.0d ? d9 : -d9;
                    if (dArr[0] >= d10) {
                        d10 = dArr[0];
                    }
                    dArr[0] = d10;
                    byteBuffer2 = byteBuffer4;
                    byteBuffer2.position(0);
                    byteBuffer2.putDouble(d9);
                    byteBuffer2.flip();
                    p(outputStream, byteBuffer2);
                } else {
                    if (i3 == 1) {
                        i8 = i6;
                        byteBuffer3 = allocate;
                        double d11 = d9 * 127.0d;
                        int c2 = i5 != 0 ? c(d11, dArr, i5, i14) : a(d11);
                        byteBuffer.position(0);
                        byteBuffer.limit(1);
                        byteBuffer.put(0, (byte) (c2 + 128));
                        byteBuffer.flip();
                        p(outputStream, byteBuffer);
                    } else if (i3 == 2) {
                        i8 = i6;
                        byteBuffer3 = allocate;
                        double d12 = d9 * 32767.0d;
                        int c3 = i5 != 0 ? c(d12, dArr, i5, i14) : a(d12);
                        byteBuffer.position(0);
                        byteBuffer.limit(2);
                        byteBuffer.asShortBuffer().put(0, (short) c3);
                        byteBuffer.flip();
                        p(outputStream, byteBuffer);
                    } else if (i3 != 3) {
                        i8 = i6;
                        byteBuffer3 = allocate;
                    } else {
                        double d13 = d9 * 8388607.0d;
                        if (i5 != 0) {
                            i8 = i6;
                            i9 = 3;
                            byteBuffer3 = allocate;
                            a2 = c(d13, dArr, i5, i14);
                        } else {
                            i8 = i6;
                            byteBuffer3 = allocate;
                            i9 = 3;
                            a2 = a(d13);
                        }
                        byteBuffer.position(0);
                        byteBuffer.limit(i9);
                        byteBuffer.put(0, (byte) (a2 & 255));
                        int i16 = a2 >> 8;
                        byteBuffer.put(1, (byte) (i16 & 255));
                        byteBuffer.put(2, (byte) ((i16 >> 8) & 255));
                        byteBuffer.flip();
                        p(outputStream, byteBuffer);
                    }
                    byteBuffer2 = byteBuffer3;
                }
                int i17 = i14 + 1;
                i14 = i17 == i ? 0 : i17;
                int i18 = i7 + 1;
                if ((262143 & i18) == 0) {
                    double d14 = i18;
                    double d15 = i8;
                    Double.isNaN(d14);
                    Double.isNaN(d15);
                    l(d14 / d15);
                }
                allocate = byteBuffer2;
                dArr2 = dArr;
                i12 = 4;
                i11 = 0;
                i13 = i18;
                allocate2 = byteBuffer;
                i10 = 1;
            }
            double d16 = d3;
            byteBuffer = wrap;
            d4 = d16;
            if (inputStream.available() != 0) {
            }
        }
        l(1.0d);
        return dArr[0];
    }

    public final void j(int i) {
    }

    public final void k() {
        this.o = System.currentTimeMillis();
        this.p = 0L;
        this.n = -1;
    }

    public final void l(double d2) {
        int i;
        if (this.m) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.o;
        if (d2 == 0.0d) {
            i = 0;
        } else {
            double d3 = currentTimeMillis;
            Double.isNaN(d3);
            i = (int) ((d3 * (1.0d - d2)) / d2);
        }
        int i2 = (int) (d2 * 100.0d);
        if (i2 != this.n || currentTimeMillis != this.p) {
            System.err.printf(" %3d%% processed", Integer.valueOf(i2));
            this.n = i2;
        }
        if (currentTimeMillis != this.p) {
            System.err.printf(", ETA =%4dmsec", Integer.valueOf(i));
            this.p = currentTimeMillis;
        }
        System.err.printf("\r", new Object[0]);
        System.err.flush();
    }

    public final double m(double d2) {
        if (d2 == 0.0d) {
            return 1.0d;
        }
        return Math.sin(d2) / d2;
    }

    /* JADX WARN: Removed duplicated region for block: B:245:0x089e  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0911  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x09bd  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x09cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double n(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, double d2, int i6, boolean z, int i7) throws IOException {
        int i8;
        double d3;
        double d4;
        int i9;
        double d5;
        int i10;
        int i11;
        ByteBuffer byteBuffer;
        int i12;
        ByteBuffer byteBuffer2;
        int i13;
        double[] dArr;
        double[] dArr2;
        double d6;
        int i14;
        int i15;
        int i16;
        ByteBuffer byteBuffer3;
        int i17;
        int i18;
        int a2;
        char c2;
        int i19;
        int i20;
        int i21;
        ByteBuffer byteBuffer4;
        int a3;
        char c3;
        int i22;
        double[] dArr3;
        double[] dArr4;
        double d7;
        int i23;
        int i24;
        int i25;
        int i26;
        int a4;
        char c4;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        j jVar = this;
        Class<double> cls = double.class;
        double[] dArr5 = {0.0d};
        int i35 = jVar.f59118e;
        double d8 = jVar.f59116c;
        int e2 = i4 / jVar.e(i4, i5);
        int i36 = e2 * i5;
        int i37 = i36 / i5;
        if (i37 == 1) {
            i8 = 1;
        } else if (i37 % 2 == 0) {
            i8 = 2;
        } else if (i37 % 3 != 0) {
            throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i37)));
        } else {
            i8 = 3;
        }
        int i38 = i5 * i8;
        int i39 = i4 / 2;
        int i40 = (i38 / 2) - i39;
        double d9 = i40 * 2;
        Double.isNaN(d9);
        double d10 = d9 / 2.0d;
        double d11 = i39;
        int i41 = i35;
        double d12 = i40;
        Double.isNaN(d12);
        Double.isNaN(d11);
        double d13 = d11 + (d12 / 2.0d);
        if (d8 <= 21.0d) {
            d4 = d11;
            d3 = 0.9222d;
        } else {
            d3 = (d8 - 7.95d) / 14.36d;
            d4 = d11;
        }
        double d14 = i36;
        Double.isNaN(d14);
        int i42 = (int) (((d14 / d10) * d3) + 1.0d);
        if (i42 % 2 == 0) {
            i42++;
        }
        int i43 = i42;
        double b2 = jVar.b(d8);
        double a5 = f.a(b2);
        int i44 = i36 / i4;
        int i45 = (i43 / i44) + 1;
        int i46 = i44 * i8;
        int[] iArr = new int[i46];
        for (int i47 = 0; i47 < i46; i47++) {
            iArr[i47] = i44 - (((i36 / i38) * i47) % i44);
            if (iArr[i47] == i44) {
                iArr[i47] = 0;
            }
        }
        int[] iArr2 = new int[i46];
        int i48 = 0;
        while (i48 < i46) {
            int i49 = i46;
            double[] dArr6 = dArr5;
            iArr2[i48] = iArr[i48] < i36 / i38 ? i : 0;
            if (iArr[i48] == i44) {
                iArr[i48] = 0;
            }
            i48++;
            i46 = i49;
            dArr5 = dArr6;
        }
        int i50 = i46;
        double[] dArr7 = dArr5;
        double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) cls, i44, i45);
        int i51 = i43 / 2;
        int i52 = -i51;
        while (i52 <= i51) {
            int i53 = i52 + i51;
            int[] iArr3 = iArr;
            int i54 = i50;
            int i55 = i52;
            Double.isNaN(d14);
            double d15 = i4;
            Double.isNaN(d15);
            dArr8[i53 % i44][i53 / i44] = ((o(i52, i43, b2, a5) * g(i55, d13, d14)) * d14) / d15;
            i52 = i55 + 1;
            jVar = this;
            i38 = i38;
            i45 = i45;
            iArr2 = iArr2;
            i43 = i43;
            i51 = i51;
            i36 = i36;
            iArr = iArr3;
            i50 = i54;
            i41 = i41;
        }
        int[] iArr4 = iArr;
        int i56 = i45;
        int i57 = i36;
        int i58 = i38;
        int i59 = i51;
        int[] iArr5 = iArr2;
        j jVar2 = jVar;
        int i60 = i41;
        int i61 = i50;
        double d16 = jVar2.f59116c;
        double d17 = d16 > 21.0d ? (d16 - 7.95d) / 14.36d : 0.9222d;
        int i62 = 1;
        while (true) {
            int i63 = i60 * i62;
            if (i63 % 2 == 0) {
                i63--;
            }
            i9 = i63;
            d5 = i58;
            Double.isNaN(d5);
            double d18 = i9 - 1;
            Double.isNaN(d18);
            if ((d5 * d17) / d18 < jVar2.f59117d) {
                break;
            }
            i62 *= 2;
            jVar2 = jVar2;
            i61 = i61;
            cls = cls;
        }
        double b3 = jVar2.b(d16);
        double a6 = f.a(b3);
        int i64 = 1;
        while (i64 < i9) {
            i64 *= 2;
        }
        int i65 = i64 * 2;
        double[] dArr9 = new double[i65];
        int i66 = i9 / 2;
        int i67 = -i66;
        while (i67 <= i66) {
            double d19 = d5;
            double[] dArr10 = dArr9;
            int i68 = i67;
            double d20 = b3;
            double d21 = b3;
            j jVar3 = jVar2;
            int i69 = i65;
            double o = o(i67, i9, d20, a6);
            d5 = d19;
            double g2 = o * g(i68, d4, d5);
            double d22 = i69;
            Double.isNaN(d22);
            dArr10[i67 + i66] = (g2 / d22) * 2.0d;
            i67 = i68 + 1;
            jVar2 = jVar3;
            i65 = i69;
            i66 = i66;
            b3 = d21;
            dArr9 = dArr10;
        }
        int i70 = i67;
        double[] dArr11 = dArr9;
        double d23 = d5;
        j jVar4 = jVar2;
        int i71 = i65;
        int[] iArr6 = new int[(int) (Math.sqrt(i71) + 2.0d)];
        iArr6[0] = 0;
        int i72 = i71 / 2;
        double[] dArr12 = new double[i72];
        jVar4.f59115b.B(i71, 1, dArr11, iArr6, dArr12);
        k();
        int i73 = (i72 / i8) + 1;
        int[] iArr7 = {r4, i73};
        int i74 = i;
        double[][] dArr13 = (double[][]) Array.newInstance((Class<?>) cls, iArr7);
        double[][] dArr14 = (double[][]) Array.newInstance((Class<?>) cls, i74, i71);
        int i75 = (i72 + i56 + 2) * i74;
        int i76 = i2;
        ByteBuffer allocate = ByteBuffer.allocate(i75 * i76);
        int i77 = i73 * i74;
        ByteBuffer allocate2 = ByteBuffer.allocate(i77 * i3);
        double[] dArr15 = new double[i75];
        double[] dArr16 = new double[i77];
        double d24 = i9;
        Double.isNaN(d24);
        int i78 = i56;
        double d25 = i58 / i5;
        Double.isNaN(d25);
        int i79 = (int) ((d24 / 2.0d) / d25);
        int i80 = (i59 / i44) + 1;
        ByteBuffer byteBuffer5 = allocate;
        int i81 = 0;
        int i82 = 0;
        int i83 = 0;
        int i84 = 0;
        int i85 = 0;
        int i86 = 0;
        boolean z2 = true;
        int i87 = i6;
        int i88 = 0;
        while (true) {
            double d26 = i72;
            double[] dArr17 = dArr16;
            double[] dArr18 = dArr15;
            double d27 = i4;
            Double.isNaN(d26);
            Double.isNaN(d27);
            Double.isNaN(d23);
            double d28 = d27;
            double d29 = i78;
            Double.isNaN(d29);
            double ceil = Math.ceil((d26 * d27) / d23) + 1.0d + d29;
            double d30 = i80;
            Double.isNaN(d30);
            int i89 = (int) (ceil - d30);
            int i90 = i89 + i81 > i87 ? i87 - i81 : i89;
            byteBuffer5.position(0);
            int i91 = i76 * i74;
            byteBuffer5.limit(i90 * i91);
            byte[] bArr = new byte[byteBuffer5.limit()];
            int read = inputStream.read(bArr);
            int i92 = i87;
            int i93 = read < 0 ? 0 : read;
            int i94 = i93 < byteBuffer5.limit() ? ((i93 / i76) * i74) + i81 : i92;
            byteBuffer5.limit(i93);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(i93);
            wrap.flip();
            int i95 = i93 / i91;
            if (i76 != 1) {
                if (i76 == 2) {
                    i11 = i71;
                    byteBuffer = allocate2;
                    i12 = 0;
                    while (i12 < i95 * i74) {
                        int i96 = i72;
                        double d31 = wrap.order(jVar4.f59114a).asShortBuffer().get(i12);
                        Double.isNaN(d31);
                        dArr18[(i74 * i80) + i12] = d31 * 3.051850947599719E-5d;
                        i12++;
                        jVar4 = this;
                        i72 = i96;
                    }
                } else if (i76 == 3) {
                    byteBuffer = allocate2;
                    i12 = 0;
                    while (i12 < i95 * i74) {
                        int i97 = i12 * 3;
                        double d32 = (wrap.get(i97 + 1) << 8) | (wrap.get(i97) << 0) | (wrap.get(i97 + 2) << 16);
                        Double.isNaN(d32);
                        dArr18[(i74 * i80) + i12] = d32 * 1.1920930376163766E-7d;
                        i12++;
                        i71 = i71;
                    }
                    i11 = i71;
                } else if (i76 != 4) {
                    i10 = i72;
                    i11 = i71;
                    i12 = i70;
                    byteBuffer = allocate2;
                } else {
                    i12 = 0;
                    while (i12 < i95 * i74) {
                        ByteBuffer byteBuffer6 = allocate2;
                        double d33 = wrap.order(jVar4.f59114a).asIntBuffer().get(i12);
                        Double.isNaN(d33);
                        dArr18[(i74 * i80) + i12] = d33 * 4.656612875245797E-10d;
                        i12++;
                        allocate2 = byteBuffer6;
                    }
                    byteBuffer = allocate2;
                    i10 = i72;
                    i11 = i71;
                }
                i10 = i72;
            } else {
                i10 = i72;
                i11 = i71;
                byteBuffer = allocate2;
                i12 = 0;
                while (i12 < i95 * i74) {
                    double d34 = wrap.get(i12);
                    Double.isNaN(d34);
                    dArr18[(i74 * i80) + i12] = (d34 - 128.0d) * 0.007874015748031496d;
                    i12++;
                }
            }
            while (i12 < i74 * i89) {
                dArr18[(i74 * i80) + i12] = 0.0d;
                i12++;
            }
            int i98 = i80 + i89;
            i81 += i95;
            boolean z3 = i81 >= i94;
            int i99 = ((((i82 - 1) * i4) + i57) / i57) * i74;
            int i100 = i83;
            int i101 = i84;
            int i102 = i85;
            int i103 = 0;
            while (i103 < i74) {
                int i104 = i99 + i103;
                if (i78 == 7) {
                    i32 = i61;
                    i33 = i10;
                    i34 = i84;
                    for (int i105 = 0; i105 < i33; i105++) {
                        int i106 = iArr4[i34];
                        dArr14[i103][i105] = (dArr8[i106][0] * dArr18[i104 + (i74 * 0)]) + (dArr8[i106][1] * dArr18[i104 + (i74 * 1)]) + (dArr8[i106][2] * dArr18[i104 + (i74 * 2)]) + (dArr8[i106][3] * dArr18[i104 + (i74 * 3)]) + (dArr8[i106][4] * dArr18[i104 + (i74 * 4)]) + (dArr8[i106][5] * dArr18[i104 + (i74 * 5)]) + (dArr8[i106][6] * dArr18[i104 + (i74 * 6)]);
                        i104 += iArr5[i34];
                        i34++;
                        if (i34 == i32) {
                            i34 = 0;
                        }
                    }
                } else if (i78 != 9) {
                    i34 = i84;
                    i33 = i10;
                    int i107 = 0;
                    while (i107 < i33) {
                        int i108 = iArr4[i34];
                        int i109 = i104;
                        double d35 = 0.0d;
                        for (int i110 = 0; i110 < i78; i110++) {
                            d35 += dArr8[i108][i110] * dArr18[i109];
                            i109 += i74;
                        }
                        dArr14[i103][i107] = d35;
                        i104 += iArr5[i34];
                        i34++;
                        int i111 = i61;
                        if (i34 == i111) {
                            i34 = 0;
                        }
                        i107++;
                        i61 = i111;
                    }
                    i32 = i61;
                } else {
                    i32 = i61;
                    i33 = i10;
                    i34 = i84;
                    for (int i112 = 0; i112 < i33; i112++) {
                        int i113 = iArr4[i34];
                        dArr14[i103][i112] = (dArr8[i113][0] * dArr18[i104 + (i74 * 0)]) + (dArr8[i113][1] * dArr18[i104 + (i74 * 1)]) + (dArr8[i113][2] * dArr18[i104 + (i74 * 2)]) + (dArr8[i113][3] * dArr18[i104 + (i74 * 3)]) + (dArr8[i113][4] * dArr18[i104 + (i74 * 4)]) + (dArr8[i113][5] * dArr18[i104 + (i74 * 5)]) + (dArr8[i113][6] * dArr18[i104 + (i74 * 6)]) + (dArr8[i113][7] * dArr18[i104 + (i74 * 7)]) + (dArr8[i113][8] * dArr18[i104 + (i74 * 8)]);
                        i104 += iArr5[i34];
                        i34++;
                        if (i34 == i32) {
                            i34 = 0;
                        }
                    }
                }
                int i114 = i11;
                for (int i115 = i33; i115 < i114; i115++) {
                    dArr14[i103][i115] = 0.0d;
                }
                this.f59115b.B(i114, 1, dArr14[i103], iArr6, dArr12);
                dArr14[i103][0] = dArr11[0] * dArr14[i103][0];
                dArr14[i103][1] = dArr11[1] * dArr14[i103][1];
                for (int i116 = 1; i116 < i33; i116++) {
                    int i117 = i116 * 2;
                    int i118 = i117 + 1;
                    dArr14[i103][i117] = (dArr11[i117] * dArr14[i103][i117]) - (dArr11[i118] * dArr14[i103][i118]);
                    dArr14[i103][i118] = (dArr11[i118] * dArr14[i103][i117]) + (dArr11[i117] * dArr14[i103][i118]);
                }
                this.f59115b.B(i114, -1, dArr14[i103], iArr6, dArr12);
                int i119 = i99;
                int i120 = i85;
                int i121 = 0;
                while (i120 < i33) {
                    dArr17[i103 + (i121 * i74)] = dArr13[i103][i121] + dArr14[i103][i120];
                    i120 += i8;
                    i121++;
                }
                int i122 = i120 - i33;
                int i123 = 0;
                while (i120 < i114) {
                    dArr13[i103][i123] = dArr14[i103][i120];
                    i120 += i8;
                    i123++;
                }
                i103++;
                i12 = i120;
                i11 = i114;
                i10 = i33;
                i101 = i34;
                i61 = i32;
                i100 = i121;
                i99 = i119;
                i102 = i122;
            }
            int i124 = i61;
            int i125 = i11;
            int i126 = i10;
            int i127 = i82 + ((i126 * e2) / i8);
            byteBuffer.clear();
            if (z) {
                int i128 = 0;
                while (i128 < i100 * i74) {
                    double d36 = dArr17[i128] > 0.0d ? dArr17[i128] : -dArr17[i128];
                    if (dArr7[0] >= d36) {
                        d36 = dArr7[0];
                    }
                    dArr7[0] = d36;
                    byteBuffer.asDoubleBuffer().put(i128, dArr17[i128]);
                    i128++;
                    wrap = wrap;
                }
                byteBuffer2 = wrap;
                i13 = i101;
                dArr = dArr18;
                dArr2 = dArr17;
                d6 = d28;
                i14 = i74;
                i15 = i102;
                i16 = i78;
                byteBuffer3 = byteBuffer;
                i18 = i128;
            } else {
                byteBuffer2 = wrap;
                if (i3 == 1) {
                    i13 = i101;
                    dArr = dArr18;
                    dArr2 = dArr17;
                    d6 = d28;
                    i14 = i74;
                    i15 = i102;
                    i16 = i78;
                    byteBuffer3 = byteBuffer;
                    i17 = i125;
                    double d37 = d2 * 127.0d;
                    i18 = 0;
                    int i129 = 0;
                    while (i18 < i100 * i14) {
                        if (i7 != 0) {
                            a2 = c(dArr2[i18] * d37, dArr7, i7, i129);
                        } else {
                            a2 = a(dArr2[i18] * d37);
                            if (a2 < -128) {
                                double d38 = a2;
                                Double.isNaN(d38);
                                double d39 = d38 / (-128.0d);
                                c2 = 0;
                                if (dArr7[0] >= d39) {
                                    d39 = dArr7[0];
                                }
                                dArr7[0] = d39;
                                a2 = com.alipay.sdk.encrypt.a.f1896g;
                            } else {
                                c2 = 0;
                            }
                            if (127 < a2) {
                                double d40 = a2;
                                Double.isNaN(d40);
                                double d41 = d40 / 127.0d;
                                if (dArr7[c2] >= d41) {
                                    d41 = dArr7[c2];
                                }
                                dArr7[c2] = d41;
                                a2 = 127;
                            }
                        }
                        byteBuffer3.put(i18, (byte) (a2 + 128));
                        int i130 = i129 + 1;
                        i129 = i130 == i14 ? 0 : i130;
                        i18++;
                    }
                } else if (i3 == 2) {
                    i13 = i101;
                    dArr = dArr18;
                    dArr2 = dArr17;
                    d6 = d28;
                    i14 = i74;
                    i15 = i102;
                    int i131 = i125;
                    ByteBuffer byteBuffer7 = byteBuffer;
                    double d42 = d2 * 32767.0d;
                    int i132 = 0;
                    int i133 = 0;
                    while (i132 < i100 * i14) {
                        if (i7 != 0) {
                            i19 = i131;
                            i21 = i132;
                            i20 = i78;
                            byteBuffer4 = byteBuffer7;
                            a3 = c(dArr2[i132] * d42, dArr7, i7, i133);
                        } else {
                            i19 = i131;
                            i20 = i78;
                            i21 = i132;
                            byteBuffer4 = byteBuffer7;
                            a3 = a(dArr2[i21] * d42);
                            if (a3 < -32768) {
                                double d43 = a3;
                                Double.isNaN(d43);
                                double d44 = d43 / (-32768.0d);
                                c3 = 0;
                                if (dArr7[0] >= d44) {
                                    d44 = dArr7[0];
                                }
                                dArr7[0] = d44;
                                a3 = -32768;
                            } else {
                                c3 = 0;
                            }
                            if (32767 < a3) {
                                double d45 = a3;
                                Double.isNaN(d45);
                                double d46 = d45 / 32767.0d;
                                if (dArr7[c3] >= d46) {
                                    d46 = dArr7[c3];
                                }
                                dArr7[c3] = d46;
                                a3 = 32767;
                            }
                        }
                        byteBuffer4.order(this.f59114a).asShortBuffer().put(i21, (short) a3);
                        int i134 = i133 + 1;
                        i133 = i134 == i14 ? 0 : i134;
                        i132 = i21 + 1;
                        byteBuffer7 = byteBuffer4;
                        i131 = i19;
                        i78 = i20;
                    }
                    i17 = i131;
                    i16 = i78;
                    i18 = i132;
                    byteBuffer3 = byteBuffer7;
                } else if (i3 != 3) {
                    i13 = i101;
                    dArr = dArr18;
                    dArr2 = dArr17;
                    d6 = d28;
                    i14 = i74;
                    i15 = i102;
                    i16 = i78;
                    byteBuffer3 = byteBuffer;
                    i18 = i12;
                } else {
                    double d47 = d2 * 8388607.0d;
                    int i135 = 0;
                    int i136 = 0;
                    while (i135 < i100 * i74) {
                        if (i7 != 0) {
                            i22 = i101;
                            dArr4 = dArr17;
                            d7 = d28;
                            i25 = i102;
                            dArr3 = dArr18;
                            i23 = i135;
                            i24 = i74;
                            i26 = i125;
                            a4 = c(dArr17[i135] * d47, dArr7, i7, i136);
                        } else {
                            i22 = i101;
                            dArr3 = dArr18;
                            dArr4 = dArr17;
                            d7 = d28;
                            i23 = i135;
                            i24 = i74;
                            i25 = i102;
                            i26 = i125;
                            a4 = a(dArr4[i23] * d47);
                            if (a4 < -8388608) {
                                double d48 = a4;
                                Double.isNaN(d48);
                                double d49 = d48 / (-8388608.0d);
                                c4 = 0;
                                if (dArr7[0] >= d49) {
                                    d49 = dArr7[0];
                                }
                                dArr7[0] = d49;
                                a4 = -8388608;
                            } else {
                                c4 = 0;
                            }
                            if (8388607 < a4) {
                                double d50 = a4;
                                Double.isNaN(d50);
                                double d51 = d50 / 8388607.0d;
                                if (dArr7[c4] >= d51) {
                                    d51 = dArr7[c4];
                                }
                                dArr7[c4] = d51;
                                a4 = 8388607;
                            }
                        }
                        int i137 = i23 * 3;
                        ByteBuffer byteBuffer8 = byteBuffer;
                        byteBuffer8.put(i137, (byte) (a4 & 255));
                        int i138 = a4 >> 8;
                        byteBuffer8.put(i137 + 1, (byte) (i138 & 255));
                        byteBuffer8.put(i137 + 2, (byte) ((i138 >> 8) & 255));
                        int i139 = i136 + 1;
                        i136 = i139 == i24 ? 0 : i139;
                        i135 = i23 + 1;
                        byteBuffer = byteBuffer8;
                        i74 = i24;
                        i125 = i26;
                        i101 = i22;
                        i102 = i25;
                        dArr18 = dArr3;
                        d28 = d7;
                        dArr17 = dArr4;
                    }
                    i13 = i101;
                    dArr = dArr18;
                    dArr2 = dArr17;
                    d6 = d28;
                    i14 = i74;
                    i15 = i102;
                    i18 = i135;
                    i16 = i78;
                    byteBuffer3 = byteBuffer;
                }
                if (z2) {
                    if (z3) {
                        double d52 = i81;
                        double d53 = i5;
                        Double.isNaN(d52);
                        Double.isNaN(d53);
                        Double.isNaN(d6);
                        double d54 = (d52 * d53) / d6;
                        int i140 = i88 + i100;
                        i27 = i94;
                        if (d54 + 2.0d > i140) {
                            byteBuffer3.position(0);
                            byteBuffer3.limit(i3 * i14 * i100);
                            p(outputStream, byteBuffer3);
                            i30 = i140;
                        } else {
                            byteBuffer3.position(0);
                            double d55 = i3 * i14;
                            double d56 = i88;
                            Double.isNaN(d56);
                            Double.isNaN(d55);
                            int floor = (int) (d55 * ((Math.floor(d54) + 2.0d) - d56));
                            if (floor > 0) {
                                byteBuffer3.limit(floor);
                                p(outputStream, byteBuffer3);
                            }
                        }
                    } else {
                        i27 = i94;
                        byteBuffer3.position(0);
                        byteBuffer3.limit(i3 * i14 * i100);
                        p(outputStream, byteBuffer3);
                        i30 = i88 + i100;
                    }
                    i28 = i18;
                    i29 = i98;
                } else {
                    int i141 = i88;
                    i27 = i94;
                    int i142 = i79;
                    if (i100 < i142) {
                        i79 = i142 - i100;
                        i30 = i141;
                        i28 = i18;
                        i29 = i98;
                    } else if (z3) {
                        double d57 = i81;
                        double d58 = i5;
                        Double.isNaN(d57);
                        Double.isNaN(d58);
                        Double.isNaN(d6);
                        double d59 = (d57 * d58) / d6;
                        i28 = i18;
                        i29 = i98;
                        if (d59 + 2.0d > (i141 + i100) - i142) {
                            int i143 = i3 * i14;
                            byteBuffer3.position(i143 * i142);
                            byteBuffer3.limit(i143 * i100);
                            p(outputStream, byteBuffer3);
                            i30 = (i100 - i142) + i141;
                            i79 = i142;
                        } else {
                            int i144 = i3 * i14;
                            byteBuffer3.position(i142 * i144);
                            double d60 = i144;
                            double d61 = i141;
                            Double.isNaN(d61);
                            Double.isNaN(d60);
                            byteBuffer3.limit((int) (d60 * ((Math.floor(d59) + 2.0d) - d61)));
                            p(outputStream, byteBuffer3);
                            break;
                        }
                    } else {
                        i28 = i18;
                        i29 = i98;
                        int i145 = i3 * i14;
                        byteBuffer3.position(i145 * i142);
                        byteBuffer3.limit(i145 * i100);
                        p(outputStream, byteBuffer3);
                        i30 = (i100 - i142) + i141;
                        i79 = i142;
                        z2 = false;
                        int i146 = (i127 - 1) / i44;
                        i80 = i29 - i146;
                        double[] dArr19 = dArr;
                        System.arraycopy(dArr19, i14 * i146, dArr19, 0, i14 * i80);
                        i82 = i127 - (i146 * i44);
                        int i147 = i86 + 1;
                        if ((i86 & 7) == 7) {
                            double d62 = i81;
                            i31 = i27;
                            double d63 = i31;
                            Double.isNaN(d62);
                            Double.isNaN(d63);
                            l(d62 / d63);
                        } else {
                            i31 = i27;
                        }
                        i88 = i30;
                        i86 = i147;
                        dArr15 = dArr19;
                        i74 = i14;
                        i87 = i31;
                        jVar4 = this;
                        byteBuffer5 = byteBuffer2;
                        i61 = i124;
                        i72 = i126;
                        i71 = i17;
                        dArr16 = dArr2;
                        i84 = i13;
                        i85 = i15;
                        i76 = i2;
                        i83 = i100;
                        i70 = i28;
                        allocate2 = byteBuffer3;
                        i78 = i16;
                    }
                }
                int i1462 = (i127 - 1) / i44;
                i80 = i29 - i1462;
                double[] dArr192 = dArr;
                System.arraycopy(dArr192, i14 * i1462, dArr192, 0, i14 * i80);
                i82 = i127 - (i1462 * i44);
                int i1472 = i86 + 1;
                if ((i86 & 7) == 7) {
                }
                i88 = i30;
                i86 = i1472;
                dArr15 = dArr192;
                i74 = i14;
                i87 = i31;
                jVar4 = this;
                byteBuffer5 = byteBuffer2;
                i61 = i124;
                i72 = i126;
                i71 = i17;
                dArr16 = dArr2;
                i84 = i13;
                i85 = i15;
                i76 = i2;
                i83 = i100;
                i70 = i28;
                allocate2 = byteBuffer3;
                i78 = i16;
            }
            i17 = i125;
            if (z2) {
            }
            int i14622 = (i127 - 1) / i44;
            i80 = i29 - i14622;
            double[] dArr1922 = dArr;
            System.arraycopy(dArr1922, i14 * i14622, dArr1922, 0, i14 * i80);
            i82 = i127 - (i14622 * i44);
            int i14722 = i86 + 1;
            if ((i86 & 7) == 7) {
            }
            i88 = i30;
            i86 = i14722;
            dArr15 = dArr1922;
            i74 = i14;
            i87 = i31;
            jVar4 = this;
            byteBuffer5 = byteBuffer2;
            i61 = i124;
            i72 = i126;
            i71 = i17;
            dArr16 = dArr2;
            i84 = i13;
            i85 = i15;
            i76 = i2;
            i83 = i100;
            i70 = i28;
            allocate2 = byteBuffer3;
            i78 = i16;
        }
        l(1.0d);
        return dArr7[0];
    }

    public final double o(double d2, int i, double d3, double d4) {
        double d5 = 4.0d * d2 * d2;
        double d6 = i;
        Double.isNaN(d6);
        double d7 = d6 - 1.0d;
        return f.a(d3 * Math.sqrt(1.0d - (d5 / (d7 * d7)))) / d4;
    }

    public void p(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(f(byteBuffer));
        } catch (IOException unused) {
        }
    }
}
