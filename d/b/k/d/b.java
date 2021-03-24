package d.b.k.d;
/* loaded from: classes2.dex */
public interface b {

    /* loaded from: classes2.dex */
    public static abstract class a implements b {
        @Override // d.b.k.d.b
        public void onDownloadProgress(float f2) {
        }

        @Override // d.b.k.d.b
        public void onDownloadStart(String str) {
        }
    }

    void onDownloadFail(String str, int i, String str2);

    void onDownloadProgress(float f2);

    void onDownloadStart(String str);

    void onDownloadSuccess(String str, String str2);
}
