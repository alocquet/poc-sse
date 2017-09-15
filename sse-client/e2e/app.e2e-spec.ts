import { SseClientPage } from './app.po';

describe('sse-client App', () => {
  let page: SseClientPage;

  beforeEach(() => {
    page = new SseClientPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
