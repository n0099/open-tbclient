package com.facebook.d;

import android.util.Pair;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class e {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [75=8, 77=8, 78=8, 79=8] */
    @Nullable
    public static Pair<Integer, Integer> E(InputStream inputStream) {
        Pair<Integer, Integer> pair = null;
        byte[] bArr = new byte[4];
        try {
            try {
                inputStream.read(bArr);
                if (f(bArr, "RIFF")) {
                    I(inputStream);
                    inputStream.read(bArr);
                    if (f(bArr, "WEBP")) {
                        inputStream.read(bArr);
                        String ar = ar(bArr);
                        if ("VP8 ".equals(ar)) {
                            pair = F(inputStream);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else if ("VP8L".equals(ar)) {
                            pair = G(inputStream);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } else if ("VP8X".equals(ar)) {
                            pair = H(inputStream);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                        } else if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                } else if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
            }
        } catch (IOException e7) {
            e7.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
        }
        return pair;
    }

    private static Pair<Integer, Integer> F(InputStream inputStream) throws IOException {
        inputStream.skip(7L);
        short L = L(inputStream);
        short L2 = L(inputStream);
        short L3 = L(inputStream);
        if (L == 157 && L2 == 1 && L3 == 42) {
            return new Pair<>(Integer.valueOf(J(inputStream)), Integer.valueOf(J(inputStream)));
        }
        return null;
    }

    private static Pair<Integer, Integer> G(InputStream inputStream) throws IOException {
        I(inputStream);
        if (M(inputStream) != 47) {
            return null;
        }
        int read = ((byte) inputStream.read()) & 255;
        return new Pair<>(Integer.valueOf(((((byte) inputStream.read()) & 255) | ((read & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((read & 192) >> 6)) + 1));
    }

    private static Pair<Integer, Integer> H(InputStream inputStream) throws IOException {
        inputStream.skip(8L);
        return new Pair<>(Integer.valueOf(K(inputStream) + 1), Integer.valueOf(K(inputStream) + 1));
    }

    private static boolean f(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (str.charAt(i) != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    private static String ar(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append((char) b2);
        }
        return sb.toString();
    }

    private static int I(InputStream inputStream) throws IOException {
        int read = (((byte) inputStream.read()) << 16) & 16711680;
        int read2 = (((byte) inputStream.read()) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        return (((byte) inputStream.read()) & 255) | read2 | read | ((((byte) inputStream.read()) << 24) & ViewCompat.MEASURED_STATE_MASK);
    }

    public static int J(InputStream inputStream) throws IOException {
        return (((byte) inputStream.read()) & 255) | ((((byte) inputStream.read()) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static int K(InputStream inputStream) throws IOException {
        byte M = M(inputStream);
        return (M & 255) | ((M(inputStream) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((M(inputStream) << 16) & 16711680);
    }

    private static short L(InputStream inputStream) throws IOException {
        return (short) (inputStream.read() & 255);
    }

    private static byte M(InputStream inputStream) throws IOException {
        return (byte) (inputStream.read() & 255);
    }
}
