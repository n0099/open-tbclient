package org.apache.http.entity.mime;

import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.protocol.HTTP;
/* loaded from: classes15.dex */
public class FormBodyPart {
    private final ContentBody body;
    private final Header header;
    private final String name;

    public FormBodyPart(String str, ContentBody contentBody) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        if (contentBody == null) {
            throw new IllegalArgumentException("Body may not be null");
        }
        this.name = str;
        this.body = contentBody;
        this.header = new Header();
        generateContentDisp(contentBody);
        generateContentType(contentBody);
        generateTransferEncoding(contentBody);
    }

    public String getName() {
        return this.name;
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public void addField(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Field name may not be null");
        }
        this.header.addField(new MinimalField(str, str2));
    }

    protected void generateContentDisp(ContentBody contentBody) {
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

    protected void generateContentType(ContentBody contentBody) {
        StringBuilder sb = new StringBuilder();
        sb.append(contentBody.getMimeType());
        if (contentBody.getCharset() != null) {
            sb.append(HTTP.CHARSET_PARAM);
            sb.append(contentBody.getCharset());
        }
        addField("Content-Type", sb.toString());
    }

    protected void generateTransferEncoding(ContentBody contentBody) {
        addField(MIME.CONTENT_TRANSFER_ENC, contentBody.getTransferEncoding());
    }
}
