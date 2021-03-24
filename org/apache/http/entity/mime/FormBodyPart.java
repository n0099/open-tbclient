package org.apache.http.entity.mime;

import org.apache.http.entity.mime.content.ContentBody;
/* loaded from: classes7.dex */
public class FormBodyPart {
    public final ContentBody body;
    public final Header header;
    public final String name;

    public FormBodyPart(String str, ContentBody contentBody) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        if (contentBody != null) {
            this.name = str;
            this.body = contentBody;
            this.header = new Header();
            generateContentDisp(contentBody);
            generateContentType(contentBody);
            generateTransferEncoding(contentBody);
            return;
        }
        throw new IllegalArgumentException("Body may not be null");
    }

    public void addField(String str, String str2) {
        if (str != null) {
            this.header.addField(new MinimalField(str, str2));
            return;
        }
        throw new IllegalArgumentException("Field name may not be null");
    }

    public void generateContentDisp(ContentBody contentBody) {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(getName());
        sb.append("\"");
        if (contentBody.getFilename() != null) {
            sb.append("; filename=\"");
            sb.append(contentBody.getFilename());
            sb.append("\"");
        }
        addField("Content-Disposition", sb.toString());
    }

    public void generateContentType(ContentBody contentBody) {
        StringBuilder sb = new StringBuilder();
        sb.append(contentBody.getMimeType());
        if (contentBody.getCharset() != null) {
            sb.append("; charset=");
            sb.append(contentBody.getCharset());
        }
        addField("Content-Type", sb.toString());
    }

    public void generateTransferEncoding(ContentBody contentBody) {
        addField(MIME.CONTENT_TRANSFER_ENC, contentBody.getTransferEncoding());
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public String getName() {
        return this.name;
    }
}
