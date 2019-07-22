package com.facebook.d;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.Pair;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [79=8, 81=8, 82=8, 83=8] */
    @Nullable
    public static Pair<Integer, Integer> A(InputStream inputStream) {
        Pair<Integer, Integer> pair = null;
        byte[] bArr = new byte[4];
        try {
            try {
                inputStream.read(bArr);
                if (i(bArr, "RIFF")) {
                    E(inputStream);
                    inputStream.read(bArr);
                    if (i(bArr, "WEBP")) {
                        inputStream.read(bArr);
                        String ad = ad(bArr);
                        if ("VP8 ".equals(ad)) {
                            pair = B(inputStream);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else if ("VP8L".equals(ad)) {
                            pair = C(inputStream);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } else if ("VP8X".equals(ad)) {
                            pair = D(inputStream);
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

    private static Pair<Integer, Integer> B(InputStream inputStream) throws IOException {
        inputStream.skip(7L);
        short H = H(inputStream);
        short H2 = H(inputStream);
        short H3 = H(inputStream);
        if (H == 157 && H2 == 1 && H3 == 42) {
            return new Pair<>(Integer.valueOf(F(inputStream)), Integer.valueOf(F(inputStream)));
        }
        return null;
    }

    private static Pair<Integer, Integer> C(InputStream inputStream) throws IOException {
        E(inputStream);
        if (I(inputStream) != 47) {
            return null;
        }
        int read = ((byte) inputStream.read()) & 255;
        return new Pair<>(Integer.valueOf(((((byte) inputStream.read()) & 255) | ((read & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((read & 192) >> 6)) + 1));
    }

    private static Pair<Integer, Integer> D(InputStream inputStream) throws IOException {
        inputStream.skip(8L);
        return new Pair<>(Integer.valueOf(G(inputStream) + 1), Integer.valueOf(G(inputStream) + 1));
    }

    private static boolean i(byte[] bArr, String str) {
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

    private static String ad(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append((char) b);
        }
        return sb.toString();
    }

    private static int E(InputStream inputStream) throws IOException {
        int read = (((byte) inputStream.read()) << 16) & 16711680;
        int read2 = (((byte) inputStream.read()) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        return (((byte) inputStream.read()) & 255) | read2 | read | ((((byte) inputStream.read()) << 24) & ViewCompat.MEASURED_STATE_MASK);
    }

    public static int F(InputStream inputStream) throws IOException {
        return (((byte) inputStream.read()) & 255) | ((((byte) inputStream.read()) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static int G(InputStream inputStream) throws IOException {
        byte I = I(inputStream);
        return (I & 255) | ((I(inputStream) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((I(inputStream) << 16) & 16711680);
    }

    private static short H(InputStream inputStream) throws IOException {
        return (short) (inputStream.read() & 255);
    }

    private static byte I(InputStream inputStream) throws IOException {
        return (byte) (inputStream.read() & 255);
    }
}
