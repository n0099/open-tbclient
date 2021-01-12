package org.apache.http.entity.mime.content;
/* loaded from: classes14.dex */
public abstract class AbstractContentBody implements ContentBody {
    private final String mediaType;
    private final String mimeType;
    private final String subType;

    public AbstractContentBody(String str) {
        if (str == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        this.mimeType = str;
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            this.mediaType = str.substring(0, indexOf);
            this.subType = str.substring(indexOf + 1);
            return;
        }
        this.mediaType = str;
        this.subType = null;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getSubType() {
        return this.subType;
    }
}
