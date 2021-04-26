package d.a.k.d;
/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public static abstract class a implements b {
        @Override // d.a.k.d.b
        public void onDownloadProgress(float f2) {
        }

        @Override // d.a.k.d.b
        public void onDownloadStart(String str) {
        }
    }

    void onDownloadFail(String str, int i2, String str2);

    void onDownloadProgress(float f2);

    void onDownloadStart(String str);

    void onDownloadSuccess(String str, String str2);
}
